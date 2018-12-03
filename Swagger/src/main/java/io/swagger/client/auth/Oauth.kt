package io.swagger.client.auth



import android.util.Base64
import android.util.Log
import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName
import io.swagger.client.Pair
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class Oauth : Authentication {

    private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://kindergarten.westeurope.cloudapp.azure.com:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val oauthTokenService: OauthTokenService = retrofit.create(OauthTokenService::class.java)

    private suspend fun getToken(): String = suspendCoroutine { continuation ->
        val username = AuthData.getInstance().username
        val password = AuthData.getInstance().password
        oauthTokenService.getToken(username, password).enqueue(object : Callback<OauthResponse> {
            override fun onFailure(call: Call<OauthResponse>, t: Throwable) {
                Log.e("oauth", "ciki van, nem jon a token")
                t.printStackTrace()
                continuation.resume("")
            }

            override fun onResponse(call: Call<OauthResponse>, response: Response<OauthResponse>) {
                val accessToken = response.body()?.accessToken
                continuation.resume(accessToken ?: "")
            }

        })
    }

    override fun applyToParams(queryParams: List<Pair>, headerParams: MutableMap<String, String>) {
        //GlobalScope.launch(Dispatchers.IO) {
            //val token = getToken()
            //headerParams["Authorization"] = "Bearer " + Base64.encodeToString(token.toByteArray(), Base64.DEFAULT)
            //Log.d("token", "alma " + token)
        //}
    }

    data class OauthResponse(
            @SerializedName("access_token")
            val accessToken: String
    )

    interface OauthTokenService {
        @GET("/oauth/token")
        fun getToken(
                @Header("username") username: String,
                @Header("password") password: String,
                @Header("grant_type") grantType: String = "password",
                @Header("client_id") clientId: String = "androidapp",
                @Header("client_secret") clientSecret: String = "lopicigaspar"
        ): Call<OauthResponse>
    }
}
