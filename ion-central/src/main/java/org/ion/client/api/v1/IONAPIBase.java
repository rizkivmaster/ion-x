package org.ion.client.api.v1;

import org.ionexchange.v1.APIResponseStatus;
import org.ionexchange.v1.objects.APIRequest;
import org.ionexchange.v1.objects.APIResponse;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * // TODO Comment
 */
public abstract class IONAPIBase {
  protected <T extends APIResponse> T okResponse(Class<T> clazz) throws IOException{
    T newClass = null;
    try {
      newClass = clazz.newInstance();
    }catch(IllegalAccessException e){
      throw new IOException("Class type not suitable",e);
    }catch(InstantiationException e){
      throw new IOException("Class type not suitable",e);
    }
    newClass.setApiResponseStatus(APIResponseStatus.SUCCESS);
    return newClass;
  }

  protected <T extends APIResponse> T okResponse(T apiResponse) throws IOException{
    apiResponse.setApiResponseStatus(APIResponseStatus.SUCCESS);
    return apiResponse;
  }
}
