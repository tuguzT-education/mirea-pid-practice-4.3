package io.github.tuguzt.eventcalendar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.databinding.DataBindingUtil
import io.github.tuguzt.eventcalendar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var moodImage: ImageView

    private lateinit var vevent: EditText
    private lateinit var vdate: EditText
    private lateinit var vtime: EditText
    private lateinit var post: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main
        ).apply { mainActivity = this@MainActivity }

        moodImage = findViewById(R.id.mood)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        moodChange(findViewById(radioGroup.checkedRadioButtonId))

        vevent = findViewById(R.id.vevent)
        vdate = findViewById(R.id.vdate)
        vtime = findViewById(R.id.vtime)
        post = findViewById(R.id.post)
    }

    fun moodChange(view: View) {
        if (view is RadioButton) {
            val image = when (view.getId()) {
                R.id.good -> R.drawable.cheerful
                else -> R.drawable.cry
            }
            if (view.isChecked)
                moodImage.setImageResource(image)
        }
    }

    fun record(view: View) {
        if (view is Button) {
            val text = """
                Записано!
                Событие: ${vevent.text}
                Дата: ${vdate.text}
                Время: ${vtime.text}
                Заметки: ${post.text}
            """.trimIndent()
            Toast.makeText(this, text, Toast.LENGTH_LONG).show()

            vevent.text.clear()
            vdate.text.clear()
            vtime.text.clear()
            post.text.clear()
        }
    }
}
