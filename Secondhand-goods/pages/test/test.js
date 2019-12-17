// pages/test/test.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    notice: 'sending'
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    let self = this;
    wx.request({
      url: 'http://localhost:8080/notice',
      method: 'GET',
      data: {
        method: 'add',
        uid: 1,
        name: 1,
        price: 1,
        quality: 10,
        campus: '崂山校区',
        tel: 110,
        remark: "It's really nice"
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        self.setData({
          notice: res.data.msg
        })
      },
      fail(res){
        console.log("异常：" + res.errMsg);
      }
    });
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})