<%--
  Created by IntelliJ IDEA.
  User: 84362
  Date: 09/25/2024
  Time: 2:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="buildingAPI" value="/api/building"/>
<c:url var="buildingList" value="/admin/building-list"/>
<c:url var="editPage" value="/admin/building-edit"/>
<html>
  <head>
    <title>Thêm Tòa Nhà</title>
  </head>
  <body>
<%--  <div class="main-container" id="main-container">--%>
    <div class="main-content">
      <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
          <script type="text/javascript">
            try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
          </script>

          <ul class="breadcrumb">
            <li>
              <i class="ace-icon fa fa-home home-icon"></i>
              <a href="#">Home</a>
            </li>
            <li class="active">Dashboard</li>
          </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
          <div class="page-header">
            <h1>
              Thêm Tòa Nhà
              <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
                overview &amp; stats
              </small>
            </h1>
          </div><!-- /.page-header -->
          <div class="row">
            <div class="col-xs-12 ">

            </div>
          </div>

          <!-- bảng tòa nhà -->
          <div class="row" style="font-family: 'Times New Roman', Times, serif; font-size: 18px;">
            <form:form  modelAttribute="buildingEdit" method="get" id="listForm">
                <div class="col-xs-12">
              <form action="" class="form-horizontal" id="form-edit">
                <!-- 1 -->
                <div class="form-group">
                  <label for="" class="col-xs-3">Tên tòa nhà</label>
                  <div class="col-xs-8">
<%--                    <input type="text" class="form-control"  id="name" name="name" />--%>
                    <form:input class="form-control" path="name" type="text"/>
                  </div>
                </div>
                <!-- 2 -->
                <div class="form-group">
                  <label for="" class="col-xs-3">Quận</label>
                  <div class="col-xs-4">
                    <form:select  path="district" name="districtId" id="districtId"  class="form-control">
                      <form:option value="0">-----Chọn Quận -----</form:option>
                      <form:options items="${listDistricts}"/>
                    </form:select>
                  </div>
                </div>
                <!-- 3 -->
                <div class="form-group">
                  <label for="" class="col-xs-3">Kết cấu</label>
                  <div class="col-xs-5">
<%--                    <input type="text" class="form-control" id="structure" name="structure"/>--%>
                    <form:input class="form-control" path="structure"/>
                  </div>
                </div>
                <!-- 4 -->
                <div class="form-group">
                  <label for="" class="col-xs-3">Phường</label>
                  <div class="col-xs-8">
<%--                    <input type="text" class="form-control" id="ward" name="ward"/>--%>
                    <form:input class="form-control" path="ward"/>
                  </div>
                </div>
                <!-- 5 -->
                <div class="form-group">
                  <label for="" class="col-xs-3">Đường</label>
                  <div class="col-xs-8">
                    <form:input class="form-control" path="street"/>
<%--                    <input type="text" class="form-control" id="street" name="street"/>--%>
                  </div>
                </div>
                <!-- 6 -->
                <div class="form-group">
                  <label for="" class="col-xs-3">Số tầng hầm</label>
                  <div class="col-xs-8">
<%--                    <input--%>
<%--                            type="number"--%>
<%--                            class="form-control"--%>
<%--                            id="numberOfBasement"--%>
<%--                            name="name"--%>
<%--                    />--%>
                    <form:input class="form-control" type="number" path="numberOfBasement"/>

                  </div>
                </div>
                <!-- 7 -->
                <div class="form-group">
                  <label for="" class="col-xs-3">Diện tích sàn</label>
                  <div class="col-xs-8">
<%--                    <input--%>
<%--                            type="number"--%>
<%--                            class="form-control"--%>
<%--                            id="floorArea"--%>
<%--                            name="floorArea"--%>
<%--                    />--%>
                    <form:input class="form-control" type="number" path="floorArea"/>

                  </div>
                </div>
                <!-- 8-->
                <div class="form-group">
                  <label for="" class="col-xs-3">Hướng</label>
                  <div class="col-xs-8">
<%--                    <input--%>
<%--                            type="text"--%>
<%--                            class="form-control"--%>
<%--                            id="direction"--%>
<%--                            name="direction"--%>
<%--                    />--%>
                    <form:input class="form-control" path="direction"/>
                  </div>
                </div>
                <!-- 9 -->
                <div class="form-group">
                  <label for="" class="col-xs-3">Hạng</label>
                  <div class="col-xs-8">
<%--                    <input--%>
<%--                            type="text"--%>
<%--                            class="form-control"--%>
<%--                            id="level"--%>
<%--                            name="level"--%>
<%--                    />--%>
                    <form:input class="form-control"  path="level"/>
                  </div>
                </div>
                <!-- 10-->
                <div class="form-group">
                  <label for="" class="col-xs-3">Diện tích thuê</label>
                  <div class="col-xs-8">
<%--                    <input--%>
<%--                            type="text"--%>
<%--                            class="form-control"--%>
<%--                            id="rentArea"--%>
<%--                            name="rentArea"--%>
<%--                    />--%>
                    <form:input type=""  class="form-control" path="rentArea"/>
                  </div>
                </div>
                <!-- 11 -->
                <div class="form-group">
                  <label for="" class="col-xs-3">Giá thuê</label>
                  <div class="col-xs-8">
<%--                    <input--%>
<%--                            type="number"--%>
<%--                            class="form-control"--%>
<%--                            id="rentPrice"--%>
<%--                            name="rentPrice"--%>
<%--                    />--%>
                     <form:input type="number"  class="form-control" path="rentPrice"/>
                  </div>
                </div>
                <!-- 12 -->
                <div class="form-group">
                  <label for="" class="col-xs-3">Mô tả giá</label>
                  <div class="col-xs-8">
<%--                    <input--%>
<%--                            type="text"--%>
<%--                            class="form-control"--%>
<%--                            id="rentPriceDescription"--%>
<%--                            name="rentPriceDescription"--%>
<%--                    />--%>
                     <form:input  class="form-control" path="rentPriceDescription"/>
                  </div>
                </div>
                <!-- 14 -->
                <div class="form-group">
                  <label for="" class="col-xs-3">Phí dịch vụ</label>
                  <div class="col-xs-8">
<%--                    <input--%>
<%--                            type="text"--%>
<%--                            class="form-control"--%>
<%--                            id="serviceFee"--%>
<%--                            name="serviceFee"--%>
<%--                    />--%>
                     <form:input  class="form-control"  path="serviceFee"/>
                  </div>
                </div>
                <!-- 15 -->
                <div class="form-group">
                  <label for="" class="col-xs-3">Phí ô tô</label>
                  <div class="col-xs-8">
<%--                    <input--%>
<%--                            type="text"--%>
<%--                            class="form-control"--%>
<%--                            id="carFee"--%>
<%--                            name="carFee"--%>
<%--                    />--%>
                     <form:input  class="form-control" path="carFee"/>
                  </div>
                </div>
                <!-- 16 -->
                <div class="form-group">
                  <label for="" class="col-xs-3">Phí mô tô</label>
                  <div class="col-xs-8">
                    <form:input  class="form-control" path="motorbikeFee"/>
                  </div>
                </div>
                <!-- 17 -->
                <div class="form-group">
                  <label for="" class="col-xs-3">Phí ngoài giờ</label>
                  <div class="col-xs-8">
<%--                    <input--%>
<%--                            type="text"--%>
<%--                            class="form-control"--%>
<%--                            id="overTimeFee"--%>
<%--                            name="overTimeFee"--%>
<%--                    /> --%>
                    <form:input  class="form-control" path="overTimeFee"/>
                  </div>
                </div>
                <!-- 18 -->
                <div class="form-group">
                  <label for="" class="col-xs-3">Tiền điên</label>
                  <div class="col-xs-8">
<%--                    <input--%>
<%--                            type="text"--%>
<%--                            class="form-control"--%>
<%--                            id="electricityFee"--%>
<%--                            name="electricityFee"--%>
<%--                    />--%>
                     <form:input   class="form-control" path="electricityFee"/>
                  </div>
                </div>
                <!-- 19-->
                <div class="form-group">
                  <label for="" class="col-xs-3">Đặt cọc</label>
                  <div class="col-xs-8">
<%--                    <input--%>
<%--                            type="text"--%>
<%--                            class="form-control"--%>
<%--                            id="deposit"--%>
<%--                            name="deposit"--%>
<%--                    />--%>
                     <form:input  class="form-control" path="deposit"/>
                  </div>
                </div>
                <!-- 20 -->
                <div class="form-group">
                  <label for="" class="col-xs-3">Thanh toán</label>
                  <div class="col-xs-8">
<%--                    <input--%>
<%--                            type="text"--%>
<%--                            class="form-control"--%>
<%--                            id="payment"--%>
<%--                            name="payment"--%>
<%--                    />--%>
                     <form:input  class="form-control"  path="payment"/>
                  </div>
                </div>
                <!-- 21 -->
                <div class="form-group">
                  <label for="" class="col-xs-3">Thời hạn thuê</label>
                  <div class="col-xs-8">
<%--                    <input--%>
<%--                            type="text"--%>
<%--                            class="form-control"--%>
<%--                            id="rentTime"--%>
<%--                            name="rentTime"--%>
<%--                    />--%>
                     <form:input  class="form-control" path="rentTime"/>
                  </div>
                </div>
                <!-- 22 -->
                <div class="form-group">
                  <label for="" class="col-xs-3">Thời gian trang trí</label>
                  <div class="col-xs-8">
<%--                    <input--%>
<%--                            type="text"--%>
<%--                            class="form-control"--%>
<%--                            id="decorationTime"--%>
<%--                            name="decorationTime"--%>
<%--                    />--%>
                     <form:input  class="form-control" path="decorationTime"/>
                  </div>
                </div>
                <!-- 23 -->
                <div class="form-group">
                  <label for="" class="col-xs-3">Tên quản lý</label>
                  <div class="col-xs-8">

                     <form:input  class="form-control" path="managerName"/>
                  </div>
                </div>
                <!-- 24 -->
                <div class="form-group">
                  <label for="" class="col-xs-3">SĐT quản lý</label>
                  <div class="col-xs-8">
<%--                    <input--%>
<%--                            type="text"--%>
<%--                            class="form-control"--%>
<%--                            id="managerPhoneNumber"--%>
<%--                            name="managerPhoneNumber"--%>
<%--                    />--%>
                     <form:input  class="form-control" path="managerPhone"/>
                  </div>
                </div>
                <!-- 25 -->
                <div class="form-group">
                  <label for="" class="col-xs-3">Phí môi giới</label>
                  <div class="col-xs-8">
<%--                    <input--%>
<%--                            type="number"--%>
<%--                            class="form-control"--%>
<%--                            id="brokerageFee"--%>
<%--                            name="brokerageFee"--%>
<%--                    />--%>
                     <form:input type="number"  class="form-control" path="brokerageFee"/>
                  </div>
                </div>
                <!-- 26 -->
                <div class="form-group">
                  <label for="" class="col-xs-3">Loại tòa nhà</label>
                  <div class="col-xs-8">
<%--                    <label for="" class="checkbox-inline">--%>
<%--                      <input--%>
<%--                              type="checkbox"--%>
<%--                              name="typeCode"--%>
<%--                              value="noi-that"--%>
<%--                              id="typeCode"--%>
<%--                      />--%>
<%--                      Nội Thất--%>
<%--                    </label>--%>
<%--                    <label for="" class="checkbox-inline">--%>
<%--                      <input--%>
<%--                              type="checkbox"--%>
<%--                              name="typeCode"--%>
<%--                              value="nguyen-can"--%>
<%--                              id="typeCode"--%>
<%--                      />--%>
<%--                      Nguyên Căn--%>
<%--                    </label>--%>
<%--                    <label for="" class="checkbox-inline">--%>
<%--                      <input--%>
<%--                              type="checkbox"--%>
<%--                              name="typeCode"--%>
<%--                              id="typeCode"--%>
<%--                              value="tang-tret"--%>
<%--                      />--%>
<%--                      Tầng Trệt--%>
<%--                    </label>--%>
                       <form:checkboxes cssStyle="margin-left: 15px;" items="${listTypeCode}" path="typeCode"  />
                  </div>
                </div>
<%--                27--%>
                <div class="form-group">
                  <label for="" class="col-xs-3">Ghi chú</label>
                  <div class="col-xs-3">
                       <form:input  class="form-control" path="note"/>
                  </div>
                </div>

                <!-- 28-->
                <div class="form-group">
                  <label for="" class="col-xs-3">Hình đại diện</label>
                  <div class="col-xs-3">
                        <input type="file" name="image" id="image" />
                        <div style="width: 200px;height: 200px;overflow: hidden;" class="image-preview">
                            <img  id="preview" src="#" alt="Preview" style="object-fit: cover; border-radius: 10px ; border: 1px solid green; width: 200px; display: block; height: 200px;" />
                        </div>
                        <div id="fileInfo">Không có tệp nào được chọn</div>
                  </div>
                </div>


                <!-- 29 -->
                <div class="form-group">
                  <div class="col-xs-12">
                    <label for="" class="col-xs-3"></label>
                    <div class="col-xs-9"></div>
                    <c:if  test="${not empty buildingEdit.id}">
                      <button  class="btn btn-success" id="btnAddOrUpdateBuilding"> Cập nhật tòa nhà </button>
                      <button class="btn btn-success" id="btnCancel">Hủy thao tác</button>
                    </c:if>
                    <c:if test="${empty buildingEdit.id}">
                      <button  class="btn btn-success" id="btnAddOrUpdateBuilding"> Thêm mới tòa nhà</button>
                      <button class="btn btn-success" id="btnCancel">Hủy thao tác</button>
                    </c:if>
                  </div>
                </div>
                <form:hidden path="id" id="buildingId" />
              </form>
            </div>
            </form:form>
          </div>

        </div><!-- /.page-content -->
      </div>
    </div><!-- /.main-content -->

<script>
  $('#btnAddOrUpdateBuilding').click(function(e){
    e.preventDefault();
    var data = {};
    var typeCode = [];
    var formData = $('#listForm').serializeArray();
    $.each(formData,function (i, v) {
      if (v.name != "typeCode") {
        data[""+ v.name+""] = v.value;
      } else {
        typeCode.push(v.value);
      }
    });
    data['typeCode'] = typeCode;
    console.log(typeCode);

    // call API
    if (data['typeCode'] && data['typeCode'].length > 0&& data['rentArea']!='') {
        addOrUpdataBuilding(data);
        alert("Thêm Mới success");
        window.location.href= "${buildingList}";
    }
    else
    {
        window.location.href = "${editPage}?error=require";
        console.log("lỗi");
    }
  });



  function addOrUpdataBuilding(data)
  {
      $.ajax({
          type: "POST",
          url: "${buildingAPI}",
          data: JSON.stringify(data),
          contentType: "application/json",
          dataType: "JSON",
          success: function (response) {
            console.log("it is oke");
          },
          error: function (response) {
            console.log("no, have a problem" + response);
            window.location.href = "${editPage}?error=require";

          }
    });
  }

        $('#btnCancel').click(function (e) {
            e.preventDefault();
            window.location.href = "${buildingList}";
        });


</script>


<script>
    document.getElementById("image").onchange = function() {
        var fileInfo = document.getElementById("fileInfo");
        var preview = document.getElementById("preview");

        if (this.files && this.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
                preview.src = e.target.result;
                preview.style.display = "block";
            }
            reader.readAsDataURL(this.files[0]);
            fileInfo.innerHTML = this.files[0].name;
        } else {
            preview.style.display = "none";
            fileInfo.innerHTML = "Không có tệp nào được chọn";
        }
    };

    function cancelAction() {
        // Thực hiện hành động hủy nếu cần thiết
        alert('Thao tác đã bị hủy.');
    }
</script>

  </body>
</html>
