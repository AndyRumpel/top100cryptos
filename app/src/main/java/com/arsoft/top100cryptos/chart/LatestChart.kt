package com.arsoft.top100cryptos.chart

import android.content.Context
import android.graphics.Color
import com.arsoft.top100cryptos.R
import com.arsoft.top100cryptos.di.App
import com.arsoft.top100cryptos.helpers.YearValueFormatter
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import javax.inject.Inject

class LatestChart {

    @Inject
    lateinit var context: Context

    @Inject
    lateinit var formatter: YearValueFormatter

    lateinit var chart: LineChart

    init {
        App.appComponent.inject(this)
    }

    fun initChart(chart: LineChart) {
        this.chart = chart

        //enable description text
        chart.description.isEnabled = false

        //enable touch gestures
        chart.setTouchEnabled(true)

        //enable scaling and dragging
        chart.isDragEnabled = true
        chart.setScaleEnabled(false)
        chart.isScaleXEnabled = true
        chart.setDrawGridBackground(false)
        chart.isDoubleTapToZoomEnabled = false

        //if disabled, scaling can be done on x- and y-axis separately
        chart.setPinchZoom(false)

        //sets the max distance in screen dp a touch can be away from
        //an entry to cause it to get highlighted
        chart.maxHighlightDistance = 300F

        val data = LineData()
        data.setValueTextColor(Color.BLACK)

        //add empty data
        chart.data = data

        //get the legend (only possible after setting data)
        chart.legend.isEnabled = true

        //add marker
        chart.setDrawMarkers(true)
        chart.marker = MyMarkerView(context, R.layout.custom_marker_view)

        val x1 = chart.xAxis
        x1.textColor = Color.BLACK
        x1.position = XAxis.XAxisPosition.BOTTOM
        x1.setDrawGridLines(false)
        x1.valueFormatter = formatter
        x1.labelCount = 3
        x1.granularity = 48F

        x1.setAvoidFirstLastClipping(true)
        x1.isEnabled = true

        val leftAxis = chart.axisLeft
        leftAxis.textColor = Color.BLACK
        leftAxis.setDrawGridLines(true)

        val rightAxis = chart.axisRight
        rightAxis.isEnabled = true
    }

    //add data to chart
    fun addEntry(value: Float, date: Float) {
        val data = chart.data

        if(data != null) {
            var set: ILineDataSet? = data.getDataSetByIndex(0)

            if(set == null) {
                set = createSet()
                data.addDataSet(set)
            }

            data.addEntry(Entry(date, value), 0)
            data.notifyDataChanged()

            chart.notifyDataSetChanged()

            chart.moveViewToX(date)

            chart.highlightValue(date, 0)
        }
    }

    private fun createSet(): LineDataSet {
        val set = LineDataSet(null, "Price, USD")

        set.mode = LineDataSet.Mode.CUBIC_BEZIER
        set.cubicIntensity = 0.2F
        set.setDrawFilled(true)
        set.setDrawCircles(false)
        set.lineWidth = 1.8F
        set.circleRadius = 4F
        set.setCircleColor(Color.BLACK)
        set.highlightLineWidth = 1.2F
        set.highLightColor = context.resources.getColor(R.color.colorAccent)
        set.color = Color.BLACK
        set.fillColor =  Color.BLACK
        set.enableDashedHighlightLine(10F, 5F, 0F)
        set.fillAlpha = 100
        set.setDrawHorizontalHighlightIndicator(true)
        set.setFillFormatter {_, _ ->
            chart.axisLeft.axisMinimum
        }

        return set

    }



}