package com.example.kidsstoryapp.storybook

import com.example.kidsstoryapp.R

object Constants {
    fun getStoryList():ArrayList<StoryModel>{
        val storyLIst=ArrayList<StoryModel>()

        val story1= StoryModel(
            R.string.title1,
            R.string.story1,
            R.string.moral1,
            R.drawable.rv_image1,
            R.drawable.image1

        )
          storyLIst.add(story1)
        val story2= StoryModel(
            R.string.title2,
            R.string.story2,
            R.string.moral2,
            R.drawable.rv_image2,
            R.drawable.image2

        )
          storyLIst.add(story2)
        val story3= StoryModel(
            R.string.title3,
            R.string.story3,
            R.string.moral3,
            R.drawable.rv_image3,
            R.drawable.image3

        )
          storyLIst.add(story3)
        val story4= StoryModel(
            R.string.title4,
            R.string.story4,
            R.string.moral4,
            R.drawable.rv_image4,
            R.drawable.image4

        )
          storyLIst.add(story4)



        val story5= StoryModel(
            R.string.title5,
            R.string.story5,
            R.string.moral5,
            R.drawable.rv_image5,
            R.drawable.image5

        )
          storyLIst.add(story5)
        val story6= StoryModel(
            R.string.title6,
            R.string.story6,
            R.string.moral6,
            R.drawable.rv_image6,
            R.drawable.image6

        )
          storyLIst.add(story6)
        val story7= StoryModel(
            R.string.title7,
            R.string.story7,
            R.string.moral7,
            R.drawable.rv_image7,
            R.drawable.image7

        )
          storyLIst.add(story7)
        val story8= StoryModel(
            R.string.title8,
            R.string.story8,
            R.string.moral8,
            R.drawable.rv_image8,
            R.drawable.image8

        )
          storyLIst.add(story8)
     val story9= StoryModel(
            R.string.title9,
            R.string.story9,
            R.string.moral9,
            R.drawable.rv_image9,
            R.drawable.image9

        )
          storyLIst.add(story9)


        return storyLIst
    }

}