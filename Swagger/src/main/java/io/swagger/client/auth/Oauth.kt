package io.swagger.client.auth

import android.util.Base64
import io.swagger.client.Pair

package io.swagger.client.auth

import android.util.Base64

import io.swagger.client.Pair

class Oauth() : Authentication {

    private fun getToken(): String {



        // todo valami halozati keres
    }

    override fun applyToParams(queryParams: List<Pair>, headerParams: MutableMap<String, String>) {
        val token = getToken()
        val str = (if (username == null) "" else username) + ":" + if (password == null) "" else password
        headerParams["Authorization"] = "Bearer " + Base64.encodeToString(str.toByteArray(), Base64.DEFAULT)
    }
}
