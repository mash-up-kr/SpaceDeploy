package kr.co.mashup.spacedeploy.spacedeploy.article

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Api(description = "감정기록 API")
@RequestMapping("/dailyArticle")
@RestController
class ArticleController(val articleService: ArticleService) {

    @ApiOperation(value = "요일별 감정기록", notes = "지정된 요일의 감정기록을 가져옵니다.")
    @GetMapping()
    fun getArticle(@RequestParam year: Int, @RequestParam month: Int, @RequestParam day: Int): ResponseEntity<ResArticleDto> {
        return ResponseEntity.status(HttpStatus.OK).body(articleService.getArticle(1, year, month, day))
    }

    @ApiOperation(value = "감정기록 저장", notes = "감정기록을 저장합니다.")
    @PostMapping()
    fun postArticle(@RequestBody articlePostDto: ResPostArticleDto) {
        ResponseEntity.status(HttpStatus.OK).body(articleService.postArticle(articlePostDto))
    }

    @ApiOperation(value = "감정기록 삭제", notes = "지정한 감정기록을 삭제합니다.")
    @DeleteMapping()
    fun deleteArticle(@PathVariable dailyLogId: Long) {
        ResponseEntity.status(HttpStatus.OK)
    }

    @ApiOperation(value = "감정기록 수정", notes = "감정기록을 수정합니다.")
    @PutMapping()
    fun editArticle(@PathVariable dailyLogId: Long) {
        ResponseEntity.status(HttpStatus.OK)
    }
}
