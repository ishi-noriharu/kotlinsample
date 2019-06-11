package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.SimpleAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_learn.*

class LearnActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn)

        // 返回按钮显示
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // 页面标题设定
        supportActionBar?.title = "歴史年代丸暗記"

        // 显示数据初始化
        val events: MutableList<Map<String, String>> = arrayListOf()
        events.add(mapOf("event" to "奴国王が後漢に使いを送り、金印を授かる", "year" to "57"))
        events.add(mapOf("event" to "東大寺大仏開眼", "year" to "752"))
        events.add(mapOf("event" to "空海が唐から帰国", "year" to "806"))
        events.add(mapOf("event" to "関東大震災", "year" to "1923"))

        // ListView每行显示用Adapter设定
        listView.adapter = SimpleAdapter(this,
            events,
            android.R.layout.simple_expandable_list_item_2,
            arrayOf("event", "year"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )

        // 每条点击事件处理
        listView.setOnItemClickListener { _, view, position, _ ->
            val data: Map<String, String> = events[position]
            val txtViewYear = view.findViewById<TextView>(android.R.id.text2)

            // 如果年份显示就变为不显示，如果不显示就变为显示
            if (txtViewYear.text == "") {
                txtViewYear.text = data["year"]
            } else {
                txtViewYear.text = ""
            }
        }
    }

    // 返回按钮按下后返回到前页面处理
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
            else -> return super.onOptionsItemSelected(item!!)
        }
        return true
    }
}
