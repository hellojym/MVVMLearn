# MVVMLearn

### LiveData: 具有生命周期监测能力的数据容器
1. 监听数据，数据发生变化(setValue)时，调用设置的回调
2. 回调函数时会根据当前组件的生命周期，选择是否调用，比如当组件已经销毁时，回调是不会调用的，切到后台后，会在页面返回时回调
3. 监听组件生命周期的活跃状态，在周期发生变化时，可以进行一些操作（onActive, onInActive）

### ViewModel：保存数据和逻辑状态的状态管理机制，与View分离
1. Activity销毁重建(旋转屏幕)时保存数据和复用
2. 多个组件共享数据，比如多个Fragment操作Activity的数据

### DataBinding：
1. 用于绑定xml和vm

## ViewModel一般要跟LiveData结合使用，比如：
1. 当数据发生变化时，VC变更相应的UI
2. fragment_1与用户交互-》修改了ViewModel数据-》fragment_2监听到数据变化-》fragment_2的UI响应数据变化