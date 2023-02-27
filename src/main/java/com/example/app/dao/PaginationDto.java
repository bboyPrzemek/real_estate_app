package com.example.app.dao;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class PaginationDto<T> {
	private List<T> content;
	private int currentPage;
	private int pages;
	private Boolean isLast;
	private Boolean isFirst;
}
