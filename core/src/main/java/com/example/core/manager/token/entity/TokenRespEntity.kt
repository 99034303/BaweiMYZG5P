package com.zy.net.protocol.resp

class TokenRespEntity {
    private var access_token: String? = null
    private var token_type: String? = null
    private var expires_in = 0

    fun getAccess_token(): String? {
        return access_token
    }

    fun setAccess_token(access_token: String?) {
        this.access_token = access_token
    }

    fun getToken_type(): String? {
        return token_type
    }

    fun setToken_type(token_type: String?) {
        this.token_type = token_type
    }

    fun getExpires_in(): Int {
        return expires_in
    }

    fun setExpires_in(expires_in: Int) {
        this.expires_in = expires_in
    }
}