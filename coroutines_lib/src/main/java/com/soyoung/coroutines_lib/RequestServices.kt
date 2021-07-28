package com.soyoung.coroutines_lib

import retrofit2.http.GET

interface RequestServices {

    @GET("https://v8/hospitals/Product?is_home=0&device_model=OPPO-PDPM00&lver=8.29.0&range=20&cityId=1&vistor_uid=0&page_display_unique_id=abb856d804acd9acd2cbcab39e6bc646&sys=2&uuid=2f16b5b5fc16885e&uid=19852363393&sdk_version=30&is_tf=0&_time=1627456923&app_id=2&menu_id=0&device_id=70063&level=1&s_mei_device_id=BDjYFrAPXKkc6cYclXO5IKAQ3fWCdXRzq3t%2Fcl38gSaLASJ85JZjfRNxSoZz%2FFhQFUFuKzYs%2BwmLo3%2FrbbHyFog%3D%3D&index=0&xy_token=e57490f72a73e7ef9aa4452321982838&hospital_id=658&s_meng_device_id=DuHTxTdES1nAT5QynXh7zEcZ1%2Bu494cjaCx1aq4e1Db1C2kyAbfNIHVnvzHMpbNDTuscw3O1QkVg1VYf%2F%2FLcCSHg&xy_sign=Gvft3v7YaXS7DVtjKPOHeg%253D%253D&pinyin=beta&device_os_version=11&xy_device_token=77b0722c595b89be02a2d39ef963645b74&ab_id=E14CEFB2F5A70D991F0ED2D2E972A3B3&request_id=2bbb5e6dae735c23d1ee43ae647172af")
    suspend fun getAllPlants() : Plant
}