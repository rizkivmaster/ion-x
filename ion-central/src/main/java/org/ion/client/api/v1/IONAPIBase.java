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
  protected <T> APIResponse<T> okResponse(Class<T> clazz) throws IOException{
    T newClass = null;
    try {
      newClass = clazz.newInstance();
    }catch(IllegalAccessException e){
      throw new IOException("Class constructor is not accessible. Please provide a public contructor.",e);
    }catch(InstantiationException e){
      throw new IOException("Class is not contructible. Please provide a plain constructor.",e);
    }
    APIResponse<T> apiResponse = new APIResponse<T>();
    apiResponse.setData(newClass);
    apiResponse.setApiResponseStatus(APIResponseStatus.SUCCESS);
    return apiResponse;
  }

  protected <T> APIResponse<T> okResponse(T data) throws IOException{
    APIResponse<T> apiResponse = new APIResponse<T>();
    apiResponse.setData(data);
    apiResponse.setApiResponseStatus(APIResponseStatus.SUCCESS);
    return apiResponse;
  }

  protected APIResponse<Void> okResponse() throws IOException{
    APIResponse<Void> apiResponse = new APIResponse<Void>();
    apiResponse.setApiResponseStatus(APIResponseStatus.SUCCESS);
    return apiResponse;
  }

  protected <T> APIResponse<T> failedResponse(String failedReason) throws IOException{
    APIResponse<T> apiResponse = new APIResponse<T>();
    apiResponse.setFailedReason(failedReason);
    apiResponse.setApiResponseStatus(APIResponseStatus.FAILED);
    return apiResponse;
  }
}
