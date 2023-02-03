package platform.services;

import platform.models.Code;
import platform.models.CodeResponse;

import java.util.List;
import java.util.Optional;

public interface CodeService {
    public Code getById(String id);
    public Code isExists(String id);
    public void save(Code code);
    public List<Code> findLast10();
    public void deleteAll();
    public CodeResponse getCodeResponse(Code code);
}
