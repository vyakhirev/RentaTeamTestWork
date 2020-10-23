package com.example.flickrapp.ui.listusers

import android.os.Looper
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import com.example.flickrapp.DataGenerator
import com.example.flickrapp.R
import com.example.flickrapp.RxRule
import com.example.flickrapp.TestApp
import com.example.flickrapp.data.UserItem
import com.example.flickrapp.data.PhotoResult
import kotlinx.android.synthetic.main.photo_item.view.*
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.*
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.android.controller.ActivityController
import org.robolectric.annotation.Config
import java.net.HttpURLConnection
import java.util.concurrent.TimeUnit

@RunWith(RobolectricTestRunner::class)
@Config(application = TestApp::class)
class ListUsersFragmentTest{

    @get:Rule
    val rxRule = RxRule()

    var mockWebServer: MockWebServer = MockWebServer()

    private lateinit var dummyList: List<UserItem>
    private lateinit var dummyPhotoResult: PhotoResult
    lateinit var fragment: ListUsersFragment
    lateinit var activityController: ActivityController<FragmentActivity>

    private fun getBody(): String {
        return dummyPhotoResult.toString()
    }

    @Before
    fun setUp() {
        dummyList = DataGenerator.getDummyGalleryList(35)
        dummyPhotoResult = PhotoResult(1, 3, 30, 90, dummyList as MutableList<UserItem>)
        val response = MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody(getBody())
                .setBodyDelay(0, TimeUnit.MILLISECONDS)

        mockWebServer.enqueue(response)
        mockWebServer.start(8090)

        fragment = ListUsersFragment()

//launchFragmentInContainer<ListPhotosFragment>()
        activityController = Robolectric.buildActivity(FragmentActivity::class.java)

        activityController.create().start().resume()

        activityController.get()
                .supportFragmentManager
                .beginTransaction()
                .add(fragment, null)
                .commit()
    }

    @Test
    fun `should load photo title into title_TV`() {

        Shadows.shadowOf(Looper.getMainLooper()).idle()
        val scenario= launchFragmentInContainer<ListUsersFragment>()
        scenario.moveToState(Lifecycle.State.RESUMED)
        val recycler = fragment.view!!.findViewById(R.id.listUsersRV) as RecyclerView
        // workaround robolectric recyclerView issue
//        recycler.measure(0, 0)
//        recycler.layout(0, 0, 100, 1000)

        val expected =
                "fool moon"

        Assert.assertEquals(
                expected,
                (recycler.findViewHolderForAdapterPosition(0)!!.itemView.title_TV as TextView).text
        )
    }

    @After
    fun clear(){
        mockWebServer.shutdown()
    }

}