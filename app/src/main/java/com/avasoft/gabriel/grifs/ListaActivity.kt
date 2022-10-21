package com.avasoft.gabriel.grifs

import android.R
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.animation.AccelerateInterpolator
import android.widget.LinearLayout
import com.avasoft.gabriel.grifs.model.CListaPecas
import com.avasoft.gabriel.grifs.model.CPecasAdapter
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper
import kotlinx.android.synthetic.main.activity_lista.*


class ListaActivity : AppCompatActivity() {

    var ListaGrifs = CListaPecas()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        ListaGrifs.AddTeste()

        eventsplace.layoutManager = LinearLayoutManager(this)
        eventsplace.adapter = CPecasAdapter(ListaGrifs.GetListaPecas(), this)

        // snapping the scroll items
        val snapHelper = GravitySnapHelper(Gravity.START)
        snapHelper.attachToRecyclerView(eventsplace)

        val handler = Handler()
        handler.postDelayed(Runnable { // Do something after 1ms = 100ms
            val viewHolderDefault =
                eventsplace.findViewHolderForAdapterPosition(0)
            val eventparentDefault =
                viewHolderDefault!!.itemView.findViewById<LinearLayout>(R.id.eventparent)
            eventparentDefault.animate().scaleY(1f).scaleX(1f).setDuration(350)
                .setInterpolator(AccelerateInterpolator()).start()
            val eventcategoryDefault =
                viewHolderDefault!!.itemView.findViewById<LinearLayout>(R.id.eventbadge)
            eventcategoryDefault.animate().alpha(1f).setDuration(300).start()
        }, 100)
    }
}
