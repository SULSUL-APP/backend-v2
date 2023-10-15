package com.sulsul.api.essay.dto.response;

import com.sulsul.api.comment.Comment;
import com.sulsul.api.comment.dto.response.CommentResponse;
import com.sulsul.api.essay.Essay;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CompletedEssayResponse extends EssayResponse {

    @Schema(description = "문의사항", example = "첨삭 잘 부탁드립니다.")
    private final String inquiry;

    @Schema(description = "학생 첨삭파일 경로",
            example = "https://sulsul.s3.ap-northeast-2.amazonaws.com/files/314a32f7_sulsul.pdf")
    private final String studentFilePath;

    @Schema(description = "강사 첨삭파일 경로",
            example = "https://sulsul.s3.ap-northeast-2.amazonaws.com/files/751b44f7_sulsul.pdf")
    private final String teacherFilePath;

    @Schema(description = "댓글 리스트")
    private final List<CommentResponse> comments = new ArrayList<>();

    private final EmptyResponse review;

    public CompletedEssayResponse(Essay essay, String studentFilePath,
                                  String teacherFilePath, List<Comment> comments) {
        super(essay);
        this.inquiry = essay.getInquiry();
        this.studentFilePath = studentFilePath;
        this.teacherFilePath = teacherFilePath;
        comments.stream()
                .map(CommentResponse::new)
                .forEach(comment -> this.comments.add(comment));
        this.review = new EmptyResponse();
    }
}