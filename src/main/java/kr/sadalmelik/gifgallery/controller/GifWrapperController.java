package kr.sadalmelik.gifgallery.controller;

import kr.sadalmelik.gifgallery.domain.GifWrapper;
import kr.sadalmelik.gifgallery.repository.GifWrapperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GifWrapperController {

    @Autowired
    GifWrapperRepository repository;

    @RequestMapping("/")
    public String getGifListView() {
        return "gifList";
    }

    @RequestMapping("/page/{pageNumber}")
    @ResponseBody
    public Page<GifWrapper> gifGifList(@PathVariable int pageNumber){
        return repository.findAll(new PageRequest(pageNumber, 10));
    }
}