package hu.kindergartendeveloperteam.app.groupactivity

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.swagger.client.api.DefaultApi
import io.swagger.client.model.Message
import kotlinx.android.synthetic.main.message_single.view.*
import kotlinx.android.synthetic.main.message_view.*
import kotlinx.android.synthetic.main.message_view.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import android.R.attr.gravity
import android.text.SpannableStringBuilder
import android.widget.LinearLayout



class MessageActivity : AppCompatActivity() {

    val db = DefaultApi()
    private var userId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.message_view)

        messages.layoutManager = LinearLayoutManager(this)
        messages.adapter = MessageRecyclerViewAdapter(mutableListOf())

        send_button.setOnClickListener {
            Log.d("ahfkhfkds",  send_text.text.toString())
            Log.d("clicked", "clidke")
            GlobalScope.launch(Dispatchers.IO) {
                db.sendMessageToUser(userId, send_text.text.toString())
                val messageList = db.getMessagesFromUser(userId)
                Log.d("messageList", messageList.toString())
                withContext(Dispatchers.Main) {
                    (messages.adapter as MessageRecyclerViewAdapter).setData(messageList)
                    messages.smoothScrollToPosition((messages.adapter as MessageRecyclerViewAdapter).itemCount - 1)
                    send_text.text = SpannableStringBuilder().append("")
                }
            }
        }

        userId = intent!!.extras!!.getInt(USER_ID)
        GlobalScope.launch (Dispatchers.IO) {
            val messageList = db.getMessagesFromUser(userId)

            withContext(Dispatchers.Main) {
                (messages.adapter as MessageRecyclerViewAdapter).setData(messageList)
                messages.smoothScrollToPosition((messages.adapter as MessageRecyclerViewAdapter).itemCount - 1)
            }
        } }

    inner class MessageRecyclerViewAdapter(
            private val messages: MutableList<Message>
    ) : RecyclerView.Adapter<MessageRecyclerViewAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.message_single, parent, false)



            return ViewHolder(view)
        }

        fun setData(data: List<Message>) {
            messages.clear()
            messages.addAll(data)
            notifyDataSetChanged()
        }

        override fun getItemCount(): Int = messages.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val message = messages[position]
            holder.text.text = message.content

            val layoutParams = holder.text.layoutParams
            val castLayoutParams = layoutParams as LinearLayout.LayoutParams
            castLayoutParams.gravity = if (message.wasSentByCurrentUser) Gravity.RIGHT else Gravity.LEFT
        }

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val text: TextView = view.message_text
        }
    }

    companion object {
        const val USER_ID = "user_id"
    }
}