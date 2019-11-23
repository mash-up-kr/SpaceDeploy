package kr.co.mashup.spacedeploy.spacedeploy.article

import org.springframework.stereotype.Service

@Service
class ArticleService(val articleRepository: ArticleRepository) {
    fun getArticle(user_id: Int, year: Int, month: Int, day: Int): ResArticleDto {
        val result = articleRepository.findFirstByUserIdAndYearAndMonthAndDay(user_id, year, month, day)
        val articleDto = ResArticleDto(result.dailylogId!!, result.emotion, result.dailylogUpdateTime, result.article)
        return articleDto
    }
}