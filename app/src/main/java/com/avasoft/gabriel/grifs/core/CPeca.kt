package com.avasoft.gabriel.grifs.core

class CPeca
{
    var designacao: String
    var estrela: Int // de 1 a 5
    var tipo: Int // 2-interior; 1-Exterior
    var categoria:Int //1- calçados; 2-membros inferiores; 3-membros superirores
    var marca: String
    var estado: Int //1-Disponivel; 2-Lavandaria; 3-Suja; 4-Nova
    var datacompra: String
    var image: String

    constructor(designacao:String,estrela:Int,tipo:Int,categoria:Int,marca:String,estado:Int,datacompra:String,image:String)
    {
        this.designacao = designacao
        this.estrela = estrela
        this.tipo = tipo
        this.categoria = categoria
        this.marca = marca
        this.estado = estado
        this.datacompra = datacompra
        this.image = image
    }

    override fun toString(): String {
        return designacao
    }

}
