# CPS_Watcher
一个简单的 CPS 监察器

## API
```java
public interface API {

    PlayerData playerData(Player player);

    double right_total_cps(PlayerData playerData);

    double right_average_cps(PlayerData playerData);

    double left_total_cps(PlayerData playerData);

    double left_average_cps(PlayerData playerData);

}
```
