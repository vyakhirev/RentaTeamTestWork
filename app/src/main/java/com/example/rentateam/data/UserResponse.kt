package com.example.rentateam.data

data class UserResponse(
        var page: Int,
        var per_page: Int,
        var total: Int,
        var total_pages: Int,
        var data: List<UserItem>
)
