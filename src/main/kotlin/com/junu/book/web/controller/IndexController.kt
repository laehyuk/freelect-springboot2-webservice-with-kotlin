package com.junu.book.web.controller

import com.junu.book.config.auth.SessionUser
import com.junu.book.service.posts.PostsService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import javax.servlet.http.HttpSession

@Controller
class IndexController(private val postsService: PostsService, private val httpSession: HttpSession) {
    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("posts", postsService.findAllDesc())
        val sessionUser = httpSession.getAttribute("user") as SessionUser?
        sessionUser?.let {
            model.addAttribute("userName", sessionUser.name)
        }
        return "index"
    }

    @GetMapping("/posts/save")
    fun savePosts(): String = "posts-save"

    @GetMapping("/posts/update/{id}")
    fun postsUpdate(@PathVariable id: Long, model: Model): String {
        val dto = postsService.findById(id)
        model.addAttribute("post", dto)
        return "posts-update"
    }
}
