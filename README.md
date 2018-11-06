# Awesome Hangboard Interval Timer #

Here's what it looks like after messing around with the UI today. I did a small demo [like-clock-ui-demo](https://github.com/mdoery/like-clock-ui-demo) to get the layout set up.

![three horizontal panels](https://raw.githubusercontent.com/mdoery/awesome-hangboard-interval-timer/master/2018-11-04-awesome-hangboard-interval-timer.png)

# 2018 Nov 5 Monday #

I made an intermediate project, called [like-clock-2-scrollviews-demo](https://github.com/mdoery/like-clock-2-scrollviews-demo), in order to experiment with scrollable ``TextViews``. Then I ported those changes over to this project. It looks like this (those digits are scrollable, vertically):

![three horizontal panels and scrollable TextViews](https://raw.githubusercontent.com/mdoery/awesome-hangboard-interval-timer/master/2018-11-06-awesome-hangboard-interval-timer.png)

# 2018 Nov 6 Tuesday #

Here's what the UI looks like now. This is all done using xml layout, not programmatically.

![three horizontal panels and two scrollable TextViews](https://raw.githubusercontent.com/mdoery/awesome-hangboard-interval-timer/master/2018-11-06-centered-awesome-hangboard-interval-timer.png)

Next: the scrollviews do not come to rest in increments, currently, so they can be misaligned with the colon (not even with it, horizontally). I want those minute and second duration scrollwheels to come to a rest with a satisfying click, exactly in line with the colon.

