# MVVMLearn

* LiveData: 具有生命周期监测能力的数据容器
1. 监听数据，数据发生变化(setValue)时，调用设置的回调
2. 回调函数时会根据当前组件的生命周期，选择是否调用，比如当组件已经销毁时，回调是不会调用的，切到后台后，会在页面返回时回调
3. 监听组件生命周期的活跃状态，在周期发生变化时，可以进行一些操作（onActive, onInActive）

* ViewModel：保存数据和逻辑状态的状态管理机制，与View分离
1. Activity销毁重建(旋转屏幕)时保存数据和复用
2. 多个组件共享数据，比如多个Fragment操作Activity的数(fragment_1与用户交互-》修改了ViewModel数据-》fragment_2监听到数据变化-》fragment_2的UI响应数据变化)

* DataBinding：类似于一种Android的xml"模板语法"，解决了xml中的UI和数据的绑定问题
1. 用于绑定xml和vm，二者可以联动，双向、单项绑定
2. 可以在xml中绑定事件，调用类方法，支持各种操作符
3. 通过BindingAdapter注解，可以给任何控件自定义attribute并任意实现其功能，甚至能覆盖Android原生控件的属性

### 注意

* 在不考虑DataBinding时，ViewModel一般要跟LiveData结合使用，当数据发生变化时，通过LiveData的监听回调去修改相应的UI
* 考虑DataBinding时，ViewModel里面存放的时ObservableField<>类型数据，会自动绑定UI和数据。此时LiveData可以用来做其他的事情，比如放到
控制层，相应数据的变化。