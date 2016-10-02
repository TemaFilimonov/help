package course.controller;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by Артем Константинович on 30.09.2016.
 */

@RestController
@RequestMapping("/")
public class MainController {

    private ConnectionRepository connectionRepository;


    @Inject
    public MainController(ConnectionRepository connectionRepository) {
        this.connectionRepository = connectionRepository;
    }

/*

    public void init(){
        java.util.Collection<Users> usersCollection = userService.getAll();
        if (connectionRepository.findPrimaryConnection(Twitter.class) != null){
            user.setName(connectionRepository.findPrimaryConnection(Twitter.class).getDisplayName());
            user.setUserType("twitter");
            userService.add(user);
           // usersCollection //TODO: make iterator
        } else {
            user.setName(connectionRepository.findPrimaryConnection(Facebook.class).getDisplayName());
            user.setUserType("facebook");
            userService.add(user);
        }
    }
*/

    public boolean getSessionStats() {
        if((connectionRepository.findPrimaryConnection(Twitter.class) == null)&&(connectionRepository.findPrimaryConnection(Facebook.class) == null)){
            return false;
        }
        return true;
    }
}
