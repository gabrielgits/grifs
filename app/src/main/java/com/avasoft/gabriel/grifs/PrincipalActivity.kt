package com.avasoft.gabriel.grifs

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.avasoft.gabriel.grifs.model.CListaPecas
import kotlinx.android.synthetic.main.activity_principal.*

class PrincipalActivity : AppCompatActivity() {

    var ListaGrifs = CListaPecas()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val aniCimaParaBaixo = AnimationUtils.loadAnimation(this,R.anim.cimaparabaixo)
        val aniEscala = AnimationUtils.loadAnimation(this,R.anim.escala)
        val aniCimaParaBaixo2 = AnimationUtils.loadAnimation(this,R.anim.cimaparabaixo2)
        val aniCimaParaBaixo3 = AnimationUtils.loadAnimation(this,R.anim.cimaparabaixo3)

        headertitle.startAnimation(aniCimaParaBaixo)
        botoes_acao.startAnimation(aniEscala)
        primeiralinha.startAnimation(aniCimaParaBaixo2)
        segundalinha.startAnimation(aniCimaParaBaixo3)
        btn_todos_grifs.startAnimation(aniEscala)



        BtAdcionar.setOnClickListener(View.OnClickListener {
            val intent: Intent = Intent(this, AdicionarActivity::class.java)
            this.startActivity(intent)
        })

        btn_todos_grifs.setOnClickListener {
            val intent: Intent = Intent(this, ListaActivity::class.java)
            this.startActivity(intent)
        }
    }
}
