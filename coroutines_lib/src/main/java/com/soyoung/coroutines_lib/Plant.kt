package com.soyoung.coroutines_lib

data class Plant(
    val errorCode: Int,
    val errorMsg: String,
    val responseData: ResponseData
)

data class ResponseData(
    val ad_ids: List<String>,
    val has_ad: String,
    val has_more: String,
    val hospital_id: String,
    val hot_product_menu: List<HotProductMenu>,
    val list: List<Info>,
    val menu_list_is_sideslip: String,
    val order_cnt: String,
    val params: Params,
    val top_cnt: String,
    val total: String,
    val yuyue_standard_str: String
)

data class HotProductMenu(
    val count: String,
    val level: String,
    val menu1_id: String,
    val name: String
)

data class Info(
    val avg_score: String,
    val bao_xian_yn: String,
    val calendar_cnt: String,
    val card_num: String,
    val card_price_online: String,
    val close_yn: String,
    val country: String,
    val display_yn: String,
    val district_1: String,
    val district_2: String,
    val each_cnt: String,
    val ext: String,
    val ext_type: String,
    val gong_yn: String,
    val hospital_id: String,
    val hospital_name: String,
    val hospital_type: String,
    val icons: List<Any>,
    val img_cover: ImgCover,
    val institution_type: String,
    val is_card: String,
    val is_height: String,
    val is_pin_tuan_yn: String,
    val is_price_full_money: String,
    val is_sy_bao: String,
    val is_vip: String,
    val is_vip_user: String,
    val labels: List<Label>,
    val marketing_language: String,
    val menu1_id: String,
    val new_user_discount_price: String,
    val new_user_discount_rate: String,
    val new_user_text: String,
    val new_user_text_show_yn: String,
    val on_sale_flag: String,
    val order_auto_cnt: String,
    val order_cnt: String,
    val ori_on_sale_end_date: String,
    val ori_on_sale_start_date: String,
    val over_30day: String,
    val page: String,
    val paystages_notice: String,
    val paystages_notice_android: String,
    val paystages_notice_android_new: String,
    val paystages_notice_new: String,
    val pid: String,
    val pin_tuan: List<Any>,
    val price_cut: String,
    val price_deposit: String,
    val price_online: String,
    val price_origin: String,
    val product_type: String,
    val remaji_url: String,
    val requestId: String,
    val route: String,
    val security: String,
    val serial_num: String,
    val showOrderCnt: String,
    val show_calendar_cnt: String,
    val show_order_cnt: String,
    val sold_cnt: String,
    val sole: String,
    val source: String,
    val spu_id: String,
    val subtitle: String,
    val title: String,
    val tj_order: String,
    val total_cnt: String,
    val tuan: Tuan,
    val video_yn: String,
    val vip_cut: String,
    val vip_price_deposit: String,
    val vip_price_online: String,
    val vip_user_on_sale: String,
    val wei_kuan: List<Any>,
    val wei_kuan_list: List<Any>,
    val wei_kuan_yn: String,
    val yuyue_standard_str: String,
    val zt_item_id: String,
    val zt_item_type: String,
    val zt_menu1: String
)

data class Params(
    val app_key: String,
    val front_param: FrontParam,
    val sign: String,
    val timestamp: String
)

data class ImgCover(
    val h: String,
    val ident: String,
    val u: String,
    val w: String
)

data class Label(
    val text: String,
    val text_color: String
)

class Tuan(
)

data class FrontParam(
    val ab_id: String,
    val city_id: String,
    val device_id: String,
    val hid: String,
    val limit: String,
    val login_user: Boolean,
    val new_user: Boolean,
    val official_post: Boolean,
    val page: String,
    val request_id: String,
    val sys: String,
    val uid: String,
    val version: String
)