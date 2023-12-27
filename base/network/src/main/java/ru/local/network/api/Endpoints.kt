package ru.local.network.api

object Endpoints {
    private const val API = "api/"

    const val AUTH_REFRESH = "${API}auth/refresh"
    const val AUTH_LOGOUT = "${API}auth/logout"

    const val CLIENTS_CHECK = "${API}clients/check"
    const val CLIENT = "${API}/client"
    const val CLIENTS_AUTH = "${API}clients/auth"
    const val CLIENTS_AUTH_OTP = "${API}clients/auth/otp"
    const val CLIENT_ME = "${API}clients"
    const val CLIENT_CHANGE_EMAIL = "${API}clients/email"
    const val CLIENT_BALANCE = "${API}clients/balance"
    const val CLIENT_TARIFFS_CURRENT = "${API}clients/tariffs"
    const val BANNERS = "${API}clients/tariffs/banners"
    const val CHANGE_PASSWORD = "${API}clients/passwords"
    const val CLIENT_SERVICES_AVAILABLE = "${API}clients/services/available"
    const val CLIENT_SERVICES_BALANCE = "${API}clients/services/balance"
    const val CLIENT_SERVICES_COST = "${API}clients/services/{id}/cost"
    const val CLIENT_SERVICES_SUBSCRIBE = "${API}clients/services/{id}/subscribe"
    const val CLIENT_SERVICES_UNSUBSCRIBE = "${API}clients/services/{id}/unsubscribe"
    const val CLIENT_TARIFFS = "${API}clients/tariffs/available"
    const val CLIENTS_TARIFFS_CONVERSIONS = "${API}clients/tariffs/conversions"
    const val CLIENT_TARIFFS_COST = "${API}clients/tariffs/{id}/cost"
    const val CLIENT_TARIFFS_CHANGE = "${API}clients/tariffs/{id}/change"

    const val TARIFFS = "${API}tariffs"
    const val TARIFF = "${API}tariffs/{id}"
    const val TARIFF_GROUP_SERVICES = "${API}tariffs/groups/{id}/services"

    //constructor endpoints
    const val CONSTRUCTOR_MATRIX = "${API}constructor/matrix"
    const val CONSTRUCTOR_PROFILE = "${API}constructor/profile"
    const val CHANGE_TRPL_CONSTRUCTOR = "${API}clients/tariffs/{id}/change/constructor"
    const val CLIENTS_INTERVAL = "${API}clients/interval/{trpl_id}"
    const val CONSTRUCTOR_CHARGE="${API}constructor/charge"
    const val CONSTRUCTOR_SETTINGS = "${API}clients/tariffs/{trpl_id}/constructor/settings"
    const val CONSTRUCTOR_MAIN_SERVICE = "${API}constructor/services/package"
    const val CONSTRUCTOR_ADDITIONAL_SERVICE = "${API}constructor/services/control"
    //shpd endpoints
    const val SHPD_MATRIX = "${API}constructor/shpd/matrix/{id}"
    const val SHPD_TICKET="${API}constructor/shpd/ticket"
    const val SERVICES_CONNECTED="${API}clients/services/connected"
    const val SHPD_CHANGE_SERVICES="${API}clients/services/shpd-change"

    //discount or modificators
    const val DISCOUNT = "${API}clients/services/discount"
    const val STORIES = "${API}stories"
    const val STORIES_VIEW = "${API}stories/{id}"

    const val USERS_AGREEMENT = "${API}users/agreement"

    const val QUESTIONS = "${API}questions"
    const val TRANSLATIONS = "${API}translations"
    const val PAY = "${API}payments"
    const val SANCTIONS = "${API}sanctions"
    const val VERSIONS = "${API}app/info?platform=android"
    const val OFFICES = "${API}departments"

    const val CLIENT_STATISTICS_SPENDING = "${API}clients/statistics/spending"
    const val CLIENT_STATISTICS_REPLENISHMENTS = "${API}clients/statistics/replenishments"
    const val CLIENT_STATISTICS_EMAIL = "${API}clients/statistics/email"

    const val NEWS_AND_STOCKS = "clients/news"
    const val NEWS_AND_STOCKS_DETAIL = "${API}clients/news/{${Fields.ID}}"

    const val REGISTER_NOTIFICATIONS = "${API}clients/device"

    const val COMPANY_CONTACTS = "${API}company/contacts"
    const val COMPANY_INFO = "${API}company/info"

    //new balance exchange (paid)
    const val RESOURCE_CONVERSION_SETTINGS = "${API}resource/conversion/settings/{${Fields.TRPL_ID}}"
    const val SERVICES_BALANCE = "${API}services/balance"
    const val EXCHANGE_PAID = "${API}resource/conversion"

    //paymentCards
    const val PAYMENT_CARDS = "${API}payments/cards"
    const val PAYMENT_BULLETS = "${API}payments/amount_templates"

    //auto payments
    const val AUTO_PAYMENT_STATUS = "${API}payments/recurrent/status"
    const val AUTO_PAYMENT_SET = "${API}payments/recurrent/set"
    const val AUTO_PAYMENT_UNSET = "${API}payments/recurrent/unset"

    //sbp
    const val PAYMENT_METHODS = "${API}payments/methods"
    const val PAYMENT_SBP = "${API}payments/sbp"
}

object Headers {
    const val AUTHORIZATION = "Authorization"
    const val BEARER = "Bearer"
    const val USER_AGENT = "X-Device-Id"
    const val PLATFORM = "Platform"
    const val APP_VERSION = "App-Version"
    const val PAYLOAD = "Payload"
}

object Fields {
    const val ID = "id"
    const val EMAIL = "email"
    const val PASSWORD = "password"
    const val FROM = "from"
    const val TO = "to"
    const val ALL = "all"
    const val TRPL_ID = "trpl_id"
}
