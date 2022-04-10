package org.zerock.exboot2.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * SampleDTO
 * - thymeleaf 작동을 위한 DTO
 *
 * @author 류지헌
 * @created 2022-04-10
 */
@Data
// toBuilder = true는 빌더 패턴으로 생성된 객체의 일부 값을 변경한 새 객체를 생성 가능케 함
@Builder(toBuilder = true)
public class SampleDTO {

    // 샘플 번호
    private Long sno;

    // 샘플 처음
    private String first;

    // 샘플 마지막
    private String last;

    // 현재 시작
    private LocalDateTime regTime;
}
