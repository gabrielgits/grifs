package com.avasoft.gabriel.grifs.model

import com.avasoft.gabriel.grifs.core.CPeca

class CListaPecas {
    private var ListaPecas = ArrayList<CPeca>()
    fun GetListaPecas(): ArrayList<CPeca>{
        return ListaPecas
    }

    fun ProcurarPeca(designacao: String): CPeca? {
        for (peca in ListaPecas) {
            if (peca.designacao == designacao)
                return peca
        }
        return null
    }

    fun AlterarEstado(designacao: String, estado: Int):Boolean
    {
        for (index:Int in 0..ListaPecas.size - 1) {
            if (ListaPecas[index].designacao == designacao) {
                ListaPecas[index].estado = estado
                return true;
            }
        }
        return false
    }
     fun AlterarPeca(designacao: String, pecanova: CPeca):Boolean
     {
         for (index:Int in 0..ListaPecas.size - 1) {
             if (ListaPecas[index].designacao == designacao) {
                 ListaPecas.set(index,pecanova)
                 return true;
             }
         }
         return false
     }
    
    fun AdcionarPeca(peca:CPeca): Boolean {
        if (ProcurarPeca(peca.designacao) != null ) {
            ListaPecas.add(peca)
            return true
        }
        return false
    }

    fun AdcionarPeca(designacao:String,tamanho:Int,tipo:Int,categoria:Int,marca:String,estado:Int,datacompra:String,image:String):Boolean {
        var peca = CPeca(designacao,tamanho,tipo,categoria,marca,estado,datacompra,image)
        return AdcionarPeca(peca)
    }

    fun AddTeste() {
        for (index:Int in 0..12) {
            ListaPecas.add(CPeca("Grif $index",index,index,index,"marca $index",index,"null","null"))
        }
    }


}