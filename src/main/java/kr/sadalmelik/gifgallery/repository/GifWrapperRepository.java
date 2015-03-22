package kr.sadalmelik.gifgallery.repository;

import kr.sadalmelik.gifgallery.domain.GifWrapper;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GifWrapperRepository extends PagingAndSortingRepository<GifWrapper, Long> {

}
