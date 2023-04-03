package org.microservice.base.config;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.client.ConditionalOnDiscoveryEnabled;
import org.springframework.context.event.EventListener;

/**
 * 어플리케이션이 기동이 완료 된 후 Eureka Status를 UP으로 갱신합니다.
 * <pre class="code">
 *   eureka.instance.initial-status: starting
 * </pre>
 * 위 설정과 함께 사용 할 경우 기동이 완료될 때 까지 어플리케이션의 등록을 지연할 수 있습니다.
 */
@ConditionalOnProperty(
  name = {"eureka.instance.initial-status", "eureka.client.register-with-eureka"})
@ConditionalOnDiscoveryEnabled
public class EurekaStatusInitializer {

  private final ApplicationInfoManager appInfoManager;

  @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
  public EurekaStatusInitializer(ApplicationInfoManager appInfoManager) {
    this.appInfoManager = appInfoManager;
  }

  @EventListener
  public void onApplicationReadyEvent(ApplicationReadyEvent event) {
    appInfoManager.setInstanceStatus(InstanceInfo.InstanceStatus.UP);
  }

}
