package com.avasoft.gabriel.grifs.model

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.avasoft.gabriel.grifs.R
import com.avasoft.gabriel.grifs.core.CPeca
import kotlinx.android.synthetic.main.itempecas.view.*


class CPecasAdapter(var ListAdapterPecasP: ArrayList<CPeca>, val context: Context): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.itempecas, p0, false))
    }

    override fun getItemCount(): Int {
        return ListAdapterPecasP.size
    }


    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        //p0?.tvAnimalType?.text = ListAdapterPecasP.get(p1)

        val Peca = ListAdapterPecasP.get(p1)

        p0.Title.setText(Peca.designacao);
        /*eventViewHolder.eventcategory.setText(event.getEventcategory());
        eventViewHolder.eventpicture.setImageDrawable(context.getResources().
        getDrawable(event.getEventpicture()));*/

    }


}
 class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    var Title = view.eventtitle





}

