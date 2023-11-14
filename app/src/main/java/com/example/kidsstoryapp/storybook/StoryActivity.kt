package com.example.kidsstoryapp.storybook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Toast
import com.example.kidsstoryapp.R
import com.example.kidsstoryapp.databinding.ActivityMainBinding
import com.example.kidsstoryapp.databinding.ActivityStoryBinding
import java.util.Locale

class StoryActivity : AppCompatActivity(),TextToSpeech.OnInitListener {
    private var tts:TextToSpeech?=null
    private lateinit var binding: ActivityStoryBinding
    private var position = 0
    private lateinit var storylist: ArrayList<StoryModel>
    private lateinit var speakableText:String
    private  var isPlaying  = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        tts=TextToSpeech(this,this)
        position = intent.getIntExtra("position", 0)
        storylist = Constants.getStoryList()
        setStoryView()
        setspeakableText()
        binding.btnNext.setOnClickListener {
            if (position < storylist.size-1) {
                onChangeStory(1)
            }
            else{
                Toast.makeText(this,"no more stories",Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnPrevious.setOnClickListener {
            if (position >0) {
               onChangeStory(-1)
            }
            else{
                Toast.makeText(this,"no more stories",Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnPlay.setOnClickListener{playStory()
        }

    }

    private fun setStoryView() {


        val story = storylist[position]
        binding.tvStoryTitle.setText(story.title)
        binding.tvMoral.setText(story.moral)
        binding.tvStory.setText(story.story)
        binding.storyImage.setImageResource(story.img2)


    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onInit(status: Int) {
        if (status==TextToSpeech.SUCCESS){
            val result=tts!!.setLanguage(Locale.ENGLISH)
            if  (result==TextToSpeech.LANG_MISSING_DATA|| result==TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("tts","initialization not supported")
            }
            else{
                Log.e("tts","initialization failed")

            }
        }

    }
    private fun speakOUt(text:String){
        tts?.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")
    }
    private fun setspeakableText(){
        speakableText=getString(storylist[position].story)+"Moral of the story"+
                getString(storylist[position].moral)
    }

    private fun playStory() {
        if (!isPlaying) {
            isPlaying = true
            speakOUt(speakableText)
            binding?.btnPlay?.setImageResource(R.drawable.pause)
        }else{
            tts?.stop()
            isPlaying=false
            binding.btnPlay.setImageResource(R.drawable.play)
        }
    }
    private fun onChangeStory(offSet:Int)
    {
           tts?.stop()
        position+=offSet
        setStoryView()
        binding.btnPlay.setImageResource(R.drawable.play
        )
        setspeakableText()

    }


    override fun onDestroy() {
        super.onDestroy()
        if(tts!=null){
            tts?.stop()
            tts?.shutdown()
        }

    }
}