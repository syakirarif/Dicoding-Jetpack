package com.syakir.myunittesting

class MainViewModel(private val cuboidModel: CuboidModel) {
    fun getCircumference() = cuboidModel.getCircumference()

    fun getSurfaceAre() = cuboidModel.getSurfaceArea()

    fun getVolume() = cuboidModel.getVolume()

    fun save(l: Double, w: Double, h: Double) {
        cuboidModel.save(l, w, h)
    }
}