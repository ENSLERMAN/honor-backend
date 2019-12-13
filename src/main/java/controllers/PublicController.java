package controllers;
import Entities.*;
import Utils.GridObject;
import Utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.*;
import sql.ResultedQuery;

import java.sql.SQLException;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    private Utils utils;
    @Autowired
    private GalleryService galleryService;

    @Autowired
    private PostService postService;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private ActionsService actionsService;

    @Autowired
    private OrdensService ordensService;
    @Autowired
    private ResultedQuery query;



    @RequestMapping("/get/all/posts")
    public List<Post> getMain() throws SQLException {
        return postService.getAllPosts();
    }
    @RequestMapping("/get/post")
    public Post getPost(@RequestParam("id") int id){
        return postService.getPostById(id);
    }

    @RequestMapping("/get/gallery")
    public List<GalleryImage> getImages(){
       // galleryDao=new GalleryImageDAO();
        return galleryService.getAllGallery();
    }
    @RequestMapping("/get/image")
    public GalleryImage getImage(@RequestParam("id") int id){
        return galleryService.getImageById(id);
    }

    @RequestMapping("/get/all/albums")
    public List<GalleryAlbum> getAlbums(){
        return albumService.getAllAlbums();
    }

    @RequestMapping("/get/album")
    public GalleryAlbum getAlbumById(@RequestParam("id") int id){
        return albumService.getAlbum(id);
    }


    @RequestMapping("/get/all/news")
    public List<News> getAllNews(){
        return newsService.getAllnews();
    }
    @RequestMapping("/get/news")
    public News getNews(@RequestParam("id") int id){
        return newsService.getNewsById(id);
    }

    @RequestMapping("/get/last/news")
    public News getLastNews(){
        return newsService.getLast();
    }
    @RequestMapping("/get/last/post")
    public Post getLastPost(){
        return postService.getLast();
    }
    @RequestMapping("/get/last/rally")
    public Actions getLastRally(){
        return actionsService.getLast(1);
    }
    @RequestMapping("/get/last/event")
    public Actions getLastEvent(){
        return actionsService.getLast(2);
    }
    @RequestMapping("/get/last/photos")
    public List<GalleryImage> getLastPhotos(){
        return galleryService.getLast();
    }
    @RequestMapping("/get/last/all")
    public Set<GridObject> getLasts(){
        Set<GridObject> grid=new HashSet<GridObject>();
        News news=newsService.getLast();
        grid.add(new GridObject(news.getTitle_image(),news.getTitle(),news.getId(),"/news","Новости"));
        Post post=postService.getLast();
        grid.add(new GridObject(post.getImage(),post.getTitle(),post.getId(),"/memories","Воспоминания"));
        Actions rally=actionsService.getLast(1);
        grid.add(new GridObject(news.getTitle_image(),rally.getTitle(),rally.getId(),"/rally","Автопробеги"));
        Actions event=actionsService.getLast(2);
        grid.add(new GridObject(news.getTitle_image(),event.getTitle(),event.getId(),"/events","Мероприятия"));
        return grid;
    }


    @RequestMapping("/get/actions/{action}")
    public List<Actions> getRallies(@PathVariable String action){
        if(action.equals("rallies"))
            return actionsService.getAllRallies(1);
        else if(action.equals("events"))
            return actionsService.getAllRallies(2);
        else
            return null;
    }

    @RequestMapping("/get/action")
    public Actions getRally(@RequestParam("id") int id){
        return actionsService.getRallyById(id);
    }

    @RequestMapping("/get/all/ordens")
    public List<Ordens> getOrdens(){
        return ordensService.getAllOrdens();
    }

    @RequestMapping("/get/orden")
    public Ordens getOrden(@RequestParam("id")int id){
        return ordensService.getOrden(id);
    }

    @RequestMapping("/add/comment/{photo_id}")
    public String addComment(@RequestBody GalleryComments comment, @PathVariable int photo_id){
        GalleryImage image=galleryService.getImageById(photo_id);
        comment.setTime(new Date());
        galleryService.addComment(image,comment);
        return "Success";
    }
}
