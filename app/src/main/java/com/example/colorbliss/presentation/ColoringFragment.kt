package com.example.colorbliss.presentation

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.graphics.*
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import com.example.colorbliss.R
import com.example.colorbliss.databinding.FragmentColoringBinding
import com.example.colorbliss.databinding.FragmentHomeBinding
import com.example.colorbliss.utilits.replaceFragmentMain
import com.example.domain.entities.Picture
import java.util.*

class ColoringFragment(
    val picture: Picture)
    : Fragment(),
    View.OnTouchListener {
    private var _binding : FragmentColoringBinding? = null
    private val binding get() = _binding!!
    private var myView: MyView? = null

    companion object {
        var paint: Paint? = null
        var pic : Int? = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentColoringBinding.inflate(inflater, container, false)

        pic = picture.picture

        myView = MyView(requireContext())
        binding.relativeLayout.addView(myView)

        paint = Paint()
        paint!!.isAntiAlias = true
        paint!!.style = Paint.Style.STROKE
        paint!!.strokeJoin = Paint.Join.ROUND
        paint!!.strokeWidth = 5f

        binding.color1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                paint!!.color = Color.parseColor("#FFCDC5")
            }
        })

        binding.color2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                paint!!.color = Color.parseColor("#ACD8FF")
            }
        })

        binding.color3.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                paint!!.color = Color.parseColor("#ACFFB9")
            }
        })

        binding.color4.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                paint!!.color = Color.parseColor("#C2ACFF")
            }
        })

        binding.color5.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                paint!!.color = Color.parseColor("#ACFFFF")
            }
        })

        binding.btClose.setOnClickListener { replaceFragmentMain(HomeFragment()) }

        myView!!.setOnTouchListener(this)

        return binding.root
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        myView!!.onTouchEvent(event!!)
        return true
    }

    class MyView(context: Context?) : View(context) {
        private val path: Path
        private var mBitmap: Bitmap
        private val pd: ProgressDialog
        private val p1 = Point()
        private var canvas: Canvas? = null

        init {
            paint = Paint()
            paint!!.isAntiAlias = true
            pd = ProgressDialog(context)
            paint!!.style = Paint.Style.STROKE
            paint!!.strokeJoin = Paint.Join.ROUND
            paint!!.strokeWidth = 5f
            val options = BitmapFactory.Options()
            options.inScaled = false
            mBitmap = BitmapFactory.decodeResource(
                resources,
                pic!!, options
            ).copy(Bitmap.Config.ARGB_8888, true)
            path = Path()
        }

        override fun onDraw(canvas: Canvas) {
            this.canvas = canvas
            val dstRect = Rect(0, 0, mBitmap.width, mBitmap.height)
            canvas.drawBitmap(mBitmap, null, dstRect, paint)
        }

        override fun onTouchEvent(event: MotionEvent): Boolean {
            val x = event.x
            val y = event.y
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    p1.x = x.toInt()
                    p1.y = y.toInt()
                    val sourceColor = mBitmap.getPixel(x.toInt(), y.toInt())
                    val targetColor = paint!!.color
                    TheTask(mBitmap, p1, sourceColor, targetColor).execute()
                    invalidate()
                }
            }
            return true
        }

        fun clear() {
            path.reset()
            invalidate()
        }

        val currentPaintColor: Int
            get() = paint!!.color

        @SuppressLint("StaticFieldLeak")
        internal inner class TheTask(
            var bmp: Bitmap,
            var pt: Point,
            var sourceColor: Int,
            var targetColor: Int
        ) :
            AsyncTask<Void?, Int?, Void?>() {
            init {
                pd.setMessage("Filling....")
                pd.show()
            }

            override fun doInBackground(vararg params: Void?): Void? {
                floodFill(bmp, pt.x, pt.y, sourceColor, targetColor)
                return null
            }

            override fun onPostExecute(result: Void?) {
                pd.dismiss()
                invalidate()
            }

            private fun floodFill(bmp: Bitmap, x: Int, y: Int, oldColor: Int, newColor: Int) {
                if (oldColor == newColor) return
                val width = bmp.width
                val height = bmp.height
                val pixels = IntArray(width * height)
                bmp.getPixels(pixels, 0, width, 0, 0, width, height)
                val queue: Queue<Point> = LinkedList()
                queue.add(Point(x, y))
                while (!queue.isEmpty()) {
                    val pt = queue.poll()
                    val nx = pt.x
                    val ny = pt.y
                    if (nx < 0 || nx >= width || ny < 0 || ny >= height || pixels[ny * width + nx] != oldColor) {
                        continue
                    }
                    pixels[ny * width + nx] = newColor
                    queue.add(Point(nx - 1, ny))
                    queue.add(Point(nx + 1, ny))
                    queue.add(Point(nx, ny - 1))
                    queue.add(Point(nx, ny + 1))
                }
                bmp.setPixels(pixels, 0, width, 0, 0, width, height)
            }
        }
    }
}