package app.example.app.mapper;
import org.springframework.data.domain.Page;
import com.example.app.dao.PaginationDto;

public class PaginationMapper {
	
	public static <T> PaginationDto <T> mapDto(Page<T> page) {
		 return PaginationDto.<T>builder()
				 .content(page.getContent())
				 .pages(page.getTotalPages())
				 .isLast(page.isLast())
				 .isFirst(page.isFirst())
				 .currentPage(page.getNumber() + 1)
				 .build();	
	}
}
