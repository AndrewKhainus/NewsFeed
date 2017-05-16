package com.radomar.newsfeed.screens.base;

import com.radomar.newsfeed.di.AppComponent;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Andrew on 15.05.2017.
 */

public interface BaseContract {

    interface View<P extends Presenter> extends BaseView<P> {
        void setupComponent(AppComponent appComponent);
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

        protected void addSubscription(Disposable disposable) {
            compositeDisposable.add(disposable);
        }

    }
}
