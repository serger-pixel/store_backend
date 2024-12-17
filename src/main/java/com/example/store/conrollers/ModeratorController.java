package com.example.store.conrollers;

import com.example.store.entities.Event;
import com.example.store.entities.UserStore;
import com.example.store.exceptions.NotModeratorException;
import com.example.store.services.NewsService;
import com.example.store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.store.services.UserService._adminRole;
import static com.example.store.services.UserService._moderatorRole;

/**
 * Класс-контроллер модератора
 */
@RestController
public class ModeratorController {

    /**
     * Сообщение о том, что пользователь не является модератором
     */
    private static final String _NotModeratorMess = "Вы не являяетесь модератором";

    /**
     * Сервис новостей
     */
    @Autowired
    private NewsService _newsService;

    /**
     * Сервис пользователя
     */
    @Autowired
    private UserService _userService;

    /**
     * Проверка роли пользователя
     * @param login логин пользователя
     * @return true/false в зависимости от результата проверки
     */
    private boolean checkUser(String login){
        UserStore localUser = _userService.getUser(login);
        if(!(localUser.getRole().equals(_moderatorRole) || localUser.getRole().equals(_adminRole))){
            return false;
        }
        return true;
    }

    /**
     * Отправка списка новостей модератора
     * @param login логин модератора
     * @return JSON с данными
     */
    @GetMapping(value="news/{login}/get")
    public ResponseEntity<Iterable<Event>> showMyNews(@PathVariable(value = "login") String login){
        if(!checkUser(login)){
            throw new NotModeratorException(_NotModeratorMess);
        }
        return ResponseEntity.ok().body(_newsService.getNews());
    }

    /**
     * Получение всех новостей из базы данных
     * @return JSON с данными
     */
    @GetMapping(value="news/get/all")
    public ResponseEntity <Iterable<Event>> getNews(){
        return ResponseEntity.ok().body(_newsService.getNews());
    }

    /**
     * Получение новости из базы данных
     * @param login логин пользователя
     * @param idEvent идентификатор новости
     * @return JSON с данными
     */
    @GetMapping(value="news/{login}/get/{idEvent}")
    public ResponseEntity<Event> getEvent(@PathVariable(value = "login") String login,
                                          @PathVariable(value="idEvent") String idEvent){
        if(!checkUser(login)){
            throw new NotModeratorException(_NotModeratorMess);
        }
        return ResponseEntity.ok().body(_newsService.getEvent(Integer.parseInt(idEvent)));
    }

    /**
     * Добавление новости в базу данных
     * @param login логин пользователя
     * @param event новость
     * @return результат добавления
     */
    @PostMapping(value="news/{login}/post")
    public ResponseEntity<Event> saveEvent(
                          @PathVariable(value = "login") String login,
                          @RequestBody Event event){
        if(!checkUser(login)){
            throw new NotModeratorException(_NotModeratorMess);
        }
        return ResponseEntity.ok().body(_newsService.saveEvent(event));
    }

    /**
     * Редактирование новости
     * @param login логин пользователя
     * @param idEvent идентификатор новости
     * @param content новый текст новости
     */
    @PutMapping(value = "news/{login}/put/{idEvent}/{content}")
    public void editEvent(@PathVariable(value = "login") String login,
                                           @PathVariable(value = "idEvent") String idEvent,
                                            @PathVariable(value = "content") String content){
        if(!checkUser(login)){
            throw new NotModeratorException(_NotModeratorMess);
        }
        Event localEvent = _newsService.getEvent(Integer.parseInt(idEvent));
        localEvent.setText(content);
        _newsService._newsRepository.save(localEvent);
    }

    /**
     * Удаление новости из базы данных
     * @param login логин пользователя
     * @param idEvent идентификатор новости
     */
    @DeleteMapping(value="news/{login}/delete/{idEvent}")
    public void deleteEvent(@PathVariable(value = "login") String login,
                            @PathVariable(value="idEvent") String idEvent){
        if(!checkUser(login)){
            throw new NotModeratorException(_NotModeratorMess);
        }
        _newsService.delete(Integer.parseInt(idEvent));
    }

}
