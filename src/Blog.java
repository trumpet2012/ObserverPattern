import java.util.ArrayList;
import java.util.Observable;

/**
 * William Trent Holliday
 * 1/26/15
 */
public class Blog {

    /**
     * Create a new blog object with the author and name of the blog.
     *
     * @param author Name of the blog author
     * @param blogName The title(name) of the blog
     */
    public Blog(String author, String blogName){
        this.authorName = author;
        this.blogName = blogName;
        blogPosts = new ArrayList<String>();
    }

    /**
     * Adds a blog post to this blog.
     *
     * @param blogContent the information in the blog post
     */
    public void addBlogPost(String blogContent){
        blogPosts.add(blogContent);
        blogObservable.setChanged(); // Let the observable know that our content has changed
        blogObservable.notifyObservers(blogContent); // Tell all our observers about the change
    }

    /**
     * Gets the observable for this blog.
     *
     * @return the observable object
     */
    public Observable getObservable() {
        return blogObservable;
    }

    /**
     * Set the observable object to use for this blog.
     *
     * @param observable the observable to use
     */
    public void setBlogObservable(BlogObservable observable) {
        blogObservable = observable;
    }

    /**
     * Add a blog subscriber for our blog. The subscriber will be added to this blogs observers.
     * They will be notified when a new blog post is added.
     *
     * @param blogSubscriber The new blog subscriber object
     */
    public void addObserver(BlogSubscriber blogSubscriber){
        blogObservable.addObserver(blogSubscriber);
    }

    /**
     * Un-subscribes the specified blog subscriber from the blog.
     *
     * @param blogSubscriber the suscriber to remove
     */
    public void deleteObserver(BlogSubscriber blogSubscriber){
        blogObservable.deleteObserver(blogSubscriber);
    }

    private String authorName; // Author of the blog
    private String blogName; // Name of blog
    private ArrayList<String> blogPosts; // Contains all of the blog posts

    private BlogObservable blogObservable; // The delegated observable

}
