package kr.co.mashup.spacedeploy.spacedeploy.article

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Api(description = "아티클 API")
@RestController
class ArticleController(val articleService: ArticleService) {

    @ApiOperation(value = "아티클", notes = "지정된 요일의 아티클을 가져옵니다.")
    @GetMapping("/article")
    fun getArticle(@RequestParam year: Int, @RequestParam month: Int, @RequestParam day: Int): ResponseEntity<ResArticleDto> {
        return ResponseEntity.status(HttpStatus.OK).body(articleService.getArticle(1, year, month, day))
    }
}
