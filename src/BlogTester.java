import java.util.Date;
import java.util.Observable;

/**
 * William Trent Holliday
 * 1/26/15
 */
public class BlogTester {
    public static void main(String[] args){
        // Create an array of blog observers
        BlogSubscriber[] subscribers = {
            new BlogSubscriber("Lacy Hall"),
            new BlogSubscriber("Theodore Willis"),
            new BlogSubscriber("Malcolm Jenkins"),
            new BlogSubscriber("Jerry Liwaski")
        };

        // Create an array of blogs
        Blog[] blogs = {
            new Blog("Teddy Williams","Practical Web Dev Solutions Blog"),
            new Blog("Cleo Patra", "Cleo's Blog")
        };

        // Assign each blog a new observable for delegation
        blogs[0].setBlogObservable(new BlogObservable());
        blogs[1].setBlogObservable(new BlogObservable());

        // Add the observers to the observable for the first blog
        blogs[0].addObserver(subscribers[0]);
        blogs[0].addObserver(subscribers[3]);

        // Add the observers the the observable for the second blog
        blogs[1].addObserver(subscribers[1]);
        blogs[1].addObserver(subscribers[2]);

        // Create new blog posts. The subscribers of the blogs will then be notified.
        blogs[0].addBlogPost("This is a blog post from Teddy Williams.");
        blogs[1].addBlogPost("This is a blog post on Cleo's blog");

    }
}
