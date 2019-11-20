# MVVMLearn

### 介绍
* **LiveData: 具有生命周期监测能力的数据容器**
 1. 监听数据，数据发生变化(setValue)时，调用设置的回调
 2. 回调函数时会根据当前组件的生命周期，选择是否调用，比如当组件已经销毁时，回调是不会调用的，切到后台后，会在页面返回时回调
 3. 监听组件生命周期的活跃状态，在周期发生变化时，可以进行一些操作（onActive, onInActive）

* **ViewModel：保存数据和逻辑状态的状态管理机制，与View分离**
 1. Activity销毁重建(旋转屏幕)时保存数据和复用
 2. 多个组件共享数据，比如多个Fragment操作Activity的数(fragment_1与用户交互-》修改了ViewModel数据-》fragment_2监听到数据变化-》fragment_2的UI响应数据变化)

* **DataBinding：类似于一种Android的xml"模板语法"，解决了xml中的UI和数据的绑定问题**
 1. 用于绑定xml和vm，二者可以联动，双向、单项绑定
 2. 可以在xml中绑定事件，调用类方法，支持各种操作符
 3. 通过BindingAdapter注解，可以给任何控件自定义attribute并任意实现其功能，甚至能覆盖Android原生控件的属性


### 优缺点分析
* 优点有很多，比如LiveData让数据变得像"活"了一样，通过回调函数可以做很多事情，而且不用担心内存泄漏。viewModel解决了Activity重建时的数据复用问题。DataBinding
极大的扩展了xml的能力，同时，跟viewmodel结合，实现数据和UI绑定，避免了代码中findViewById繁琐的步骤,而且如果要更新UI，只需要更新数据即可。另外，代码量会减小，
提高开发效率
* 缺点的话：除了学习成本高，理解稍微复杂，dataBinding使得调试变得不便。另外，ViewModel中不能用Context，很蛋疼。

### 个人对jetpack mvvm框架的一些看法

* 这三个框架是可以分别来用的，但是构建完整的mvvm框架，最好是三个都用。
* DataBinding跟ViewModel最好是结对使用，因为你即使不用google的ViewModel，你也得用自己写的ViewModel，我们没有理由不去用它。
* LiveData是比较灵活的一个框架，自带生命周期管理，不用担心内存泄漏。典型的我们将获取网络数据的返回response
包装到LiveData中，进行观察，当数据获取到以后，利用回调函数更新UI。在mvvm框架中，个人觉得这个不是必须的，但是建议使用。

### 注意事项
dataBinding有个坑要注意，我们用ObservableField保存数据进行观察的时候，如果里面数据保存的是一个对象，当对象内容修改时，该对象字段绑定的UI是不会更新的。如果需要监听对象
的某个字段，需要拿出来单独放到一个ObservableField中

