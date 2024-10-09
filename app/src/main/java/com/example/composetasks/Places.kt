package com.example.composetasks

data class  Places(
    var placeName : String,
    var place :  String,
    var imageRes : Int,
)
fun getAllPlaces(): List<Places>{
    return listOf<Places>(
        Places("Eiffel tower", "Paris", R.drawable.eiffeltower),
        Places("Taj Mahal ", "Agra", R.drawable.taj),
        Places("Big Ben", "London", R.drawable.bigben),
        Places("Greatwall", "China", R.drawable.greatwall),
        Places("Statue of Liberty", "NewYork", R.drawable.liberty),
        Places("Pyramids", "Egypt", R.drawable.pyramids),
        Places("Manchupichuu", "Cusco", R.drawable.manchupinchu),
        Places("Collosum", "Rome", R.drawable.colosum),
        Places("Jantar Mantar", "Delhi", R.drawable.jantar),
        Places("Eiffel tower", "Paris", R.drawable.a),
        Places("Eiffel tower", "Paris", R.drawable.a),
        Places("Eiffel tower", "Paris", R.drawable.a),
    )
}