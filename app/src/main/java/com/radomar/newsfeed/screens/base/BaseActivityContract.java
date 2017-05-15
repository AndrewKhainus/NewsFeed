package com.radomar.newsfeed.screens.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.radomar.newsfeed.di.AppComponent;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Andrew on 15.05.2017.
 */

public interface BaseActivityContract {

    interface View<P extends Presenter> extends BaseView<P> {
        void findUI();
        void setupUI();
        void setupComponent(AppComponent appComponent);
        void showErrorMessage(String message);
        <T extends BaseActivity> void startActivity(Class<T> tClass, @Nullable Bundle bundle);
        void readBundle(Bundle bundle);
    }

    abstract class Presenter<V extends View> implements BasePresenter<V> {
        private CompositeDisposable compositeDisposable;

        public Presenter() {
            compositeDisposable = new CompositeDisposable();
        }

        protected V view;

        @Override
        public void bindView(V view) {
            this.view = view;
        }

        @Override
        public void onDestroyView() {
            if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
                compositeDisposable.dispose();
            }

            view = null;
        }

        @Override
        public void onViewCreated() {

        }

        public void addSubscription(Disposable disposable) {
            compositeDisposable.add(disposable);
        }

//        public <T> Observable<T> execute(Observable<T> observable) {
//            return observable
//                    .timeout(Constants.Api.TIMEOUT, TimeUnit.SECONDS)
//                    .subscribeOn(Schedulers.computation())
//                    .observeOn(AndroidSchedulers.mainThread());
//        }
    }
}
