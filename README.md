# sample_imageSpan
Sample project on how to use ImageSpan to replace the specific span of TextView with resources

![Screenshot_1585467406](https://user-images.githubusercontent.com/40135056/77844669-6ab54180-71e3-11ea-90a0-1ac41bfb46db.png)
![Screenshot_1585467442](https://user-images.githubusercontent.com/40135056/77844671-6f79f580-71e3-11ea-819e-9a76509b3609.png)

When you have string value like below, replace the span of "cameraIcon" with a camera icon resources with ImageSpan
```
// value/strings
<string name="explanation">Press cameraIcon please!!</string>
// value-ja/strings
<string name="explanation">cameraIconをタップしてね！</string>
```

```@kotlin
val string = resources.getString(R.string.explanation)
val spanText = "cameraIcon"

val startPosition = string.split(spanText)[0].length
val endPosition = startPosition + spanText.length

val ss = SpannableString(string)
val drawable = ContextCompat.getDrawable(this, R.drawable.ic_photo)
        
        // Adjust size of drawable to fit with text height
val lineHeight = textView.lineHeight
drawable!!.setBounds(0,0,lineHeight, lineHeight)
ss.setSpan(ImageSpan(drawable), startPosition, endPosition, SPAN_EXCLUSIVE_EXCLUSIVE)

textView.text = ss

```
