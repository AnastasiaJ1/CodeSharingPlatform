package platform.services.impl;

import org.springframework.stereotype.Service;
import platform.database.CodeRepository;
import platform.models.Code;
import platform.models.CodeResponse;
import platform.services.CodeService;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@Service
public class CodeServiceImpl implements CodeService {
    private final CodeRepository repository;


    public CodeServiceImpl(CodeRepository repository) {
        this.repository = repository;
    }
    @Override
    public Code getById(String id){
        if(repository.findById(id).isPresent()){
            Code code = repository.getById(id);
            if(code.getSecretViews() == 1) {
                Long curViews = code.getViews() - 1;
                System.out.println("views" + curViews.toString());
                if (curViews == -1) {
                    repository.deleteAllById(Collections.singleton(id));
                    return null;
                }
                code.setViews(curViews);

            }
            if(code.getSecretTime() == 1){
                Long curTime = - ChronoUnit.SECONDS.between(LocalDateTime.now(), code.getDateForDiff());
                if(curTime > code.getTimeInit()){
                    repository.deleteAllById(Collections.singleton(id));
                    return null;
                }
                code.setTime(code.getTimeInit() - curTime);

            }
            if(code.getSecretTime() == 1 || code.getSecretViews() == 1){
                repository.deleteAllById(Collections.singleton(id));
                repository.save(code);
            }
            return code;
        }
        return null;
    }

    @Override
    public Code isExists(String id){
        if(repository.findById(id).isPresent()){
            Code code = repository.getById(id);
            if(code.getSecretViews() == 1) {
                Long curViews = code.getViews();
                System.out.println("views" + curViews.toString());
                if (curViews == 0) {
                    repository.deleteAllById(Collections.singleton(id));
                    return null;
                }
                code.setViews(curViews);
            }
            if(code.getSecretTime() == 1){
                Long curTime = - ChronoUnit.SECONDS.between(LocalDateTime.now(), code.getDateForDiff());
                if(curTime > code.getTimeInit()){
                    repository.deleteAllById(Collections.singleton(id));
                    return null;
                }
                code.setTime(code.getTimeInit() - curTime);
            }
            if(code.getSecretTime() == 1 || code.getSecretViews() == 1){
                repository.deleteAllById(Collections.singleton(id));
                repository.save(code);
            }
            return code;
        }
        return null;
    }
    @Override
    public void save(Code code){
        repository.save(code);
    }
    @Override
    public List<Code> findLast10(){
        return repository.findLast10();
    }
    @Override
    public void deleteAll(){
        repository.deleteAll();
    }
    @Override
    public CodeResponse getCodeResponse(Code code){
        Long time = 0L;
        Long views = 0L;
        if(code.getSecretTime() == 1){
            time = code.getTime();
        }
        if(code.getSecretViews() == 1){
            views = code.getViews();
        }
        return new CodeResponse(code.getId(), code.getCode(), code.getDate(), time, views);
    }

}
