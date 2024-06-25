<template>
  <div role="main" class="main">
    <section
      class="page-header page-header-modern bg-color-grey page-header-lg"
    >
      <div class="container">
        <div class="row">
          <div class="col-md-12 align-self-center p-static order-2 text-center">
            <h1 class="font-weight-bold text-dark">회원가입</h1>
          </div>
        </div>
      </div>
    </section>

    <div class="container py-4">
      <div class="row justify-content-center">
        <div class="col-md-6 col-lg-5">
          <!-- <h2 class="font-weight-bold text-5 mb-0">회원가입</h2> -->

          <!-- vue에서 양식은 제출할때 @click 대신 @submit.prevent="submitForm" 방식은 선호함 
          필수로 된 필드나 비동기로 방식으로 제춣할 때 이점을 가질 수 있음.
          Ajax를 사용하는 경우 양식 제출을 방지해야 한다?.
           -->
          <form @submit.prevent="enterRegister" id="frmSignUp">
            <!-- 사업자 번호 입력 -->
            <div class="form-group col">
              <label class="form-label text-color-dark text-3"
                >사업자 번호 입력
                <span class="text-color-danger">*</span></label
              >
              <input
                type="text"
                v-model="cmnRgtrrtnNmbr"
                class="form-control form-control-lg text-4"
                required
                placeholder="사업자 번호 10자리를 입력해주세요"
              />
            </div>
            <!-- 사업자 번호 입력 끝 -->
            <div v-if="numState == true">
              <div class="row">
                <div class="form-group col">
                  <label class="form-label text-color-dark text-3"
                    >아이디 <span class="text-color-danger">*</span></label
                  >
                  <input
                    type="text"
                    v-model="entrprsId"
                    class="form-control form-control-lg text-4"
                    required
                    placeholder="영문, 숫자를 포함한 4자 이상 20자 이내"
                  />
                  <div v-if="errorEntrprsId" class="error">
                    {{ errorEntrprsId }}
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="form-group col">
                  <label class="form-label text-color-dark text-3"
                    >비밀번호 <span class="text-color-danger">*</span></label
                  >
                  <input
                    type="password"
                    v-model="entrprsPswrd"
                    class="form-control form-control-lg text-4"
                    required
                    placeholder="영문, 숫자를 포함한 4자 이상 20자 이내"
                  />
                  <div v-if="errorEntrprsPswrd" class="error">
                    {{ errorEntrprsPswrd }}
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="form-group col">
                  <label class="form-label text-color-dark text-3"
                    >비밀번호 확인
                    <span class="text-color-danger">*</span></label
                  >
                  <input
                    type="password"
                    v-model="pswrdConfirm"
                    class="form-control form-control-lg text-4"
                    required
                  />
                  <div v-if="errorEntrprsPswrdConfirm" class="error">
                    {{ errorEntrprsPswrdConfirm }}
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="form-group col">
                  <label class="form-label text-color-dark text-3"
                    >이름 <span class="text-color-danger">*</span></label
                  >
                  <input
                    type="text"
                    v-model="entrprsPicName"
                    class="form-control form-control-lg text-4"
                    required
                  />
                  <div v-if="errorEntrprsPicName" class="error">
                    {{ errorEntrprsPicName }}
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="form-group col">
                  <label class="form-label text-color-dark text-3"
                    >기업명 <span class="text-color-danger">*</span></label
                  >
                  <input
                    type="text"
                    v-model="entrprsName"
                    class="form-control form-control-lg text-4"
                    required
                    placeholder="기업명"
                  />
                </div>
              </div>
              <div class="row">
                <div class="form-group col">
                  <label class="form-label text-color-dark text-3"
                    >휴대폰 <span class="text-color-danger">*</span></label
                  >
                  <input
                    type="text"
                    v-model="entrprsPicMp"
                    class="form-control form-control-lg text-4"
                    required
                    placeholder="-(다시)는 제외하고 입력"
                  />
                  <div v-if="errorEntrprsPicMp" class="error">
                    {{ errorEntrprsPicMp }}
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="form-group col-9">
                  <label class="form-label text-color-dark text-3"
                    >이메일 <span class="text-color-danger">*</span></label
                  >
                  <input
                    type="email"
                    v-model="entrprsPicEml"
                    class="form-control form-control-lg text-4"
                    required
                  />
                  <div v-if="errorEntrprsPicEml" class="error">
                    {{ errorEntrprsPicEml }}
                  </div>
                </div>
                <div class="form-group col-3">
                  <div class="form-label text-color-dark text-3">&nbsp;</div>
                  <button
                    type="button"
                    v-on:click="emlSend"
                    class="btn btn-quaternary mb-2"
                  >
                    인증요청
                  </button>
                </div>
              </div>
              <div class="row">
                <div class="form-group col-9">
                  <label class="form-label text-color-dark text-3"
                    >인증 코드 <span class="text-color-danger">*</span></label
                  >
                  <input
                    type="text"
                    v-model="emailKey"
                    @input="updateEmailCheck"
                    class="form-control form-control-lg text-4"
                    required
                  />
                </div>
                <div class="form-group col-3">
                  <div class="form-label text-color-dark text-3">&nbsp;</div>
                  <button
                    type="button"
                    v-on:click="emlChck"
                    class="btn btn-quaternary mb-2"
                  >
                    확인
                  </button>
                </div>
                <div v-if="errorEntrprsEmlRcvYn" class="error">
                  {{ errorEntrprsEmlRcvYn }}
                </div>
              </div>
              <div class="row">
                <div class="form-group col">
                  <label class="form-label text-color-dark text-3"
                    >이메일 수신 체크
                    <span class="text-color-danger">*</span></label
                  >
                  <div
                    class="form-group col form-control form-control-lg text-4"
                  >
                    <input
                      type="radio"
                      value="Y"
                      v-model="entrprsEmlRcvYn"
                      required
                      class="form-check-input"
                    />
                    예
                    <input
                      type="radio"
                      value="N"
                      v-model="entrprsEmlRcvYn"
                      required
                      class="form-check-input"
                    />
                    아니오
                  </div>
                </div>
              </div>
              <!-- <div class="row">
                              <div class="form-group col">
                                  <label class="form-label text-color-dark text-3">회원 개인정보 약관 체크 <span class="text-color-danger">*</span></label>
                                  <div class="form-group col form-control form-control-lg text-4">
                                      <input type="radio" value="Y" v-model="mbrPrvcyTrmsChck" required class="form-check-input"> 예
                                      <input type="radio" value="N" v-model="mbrPrvcyTrmsChck" required class="form-check-input"> 아니오
                                  </div>
                              </div>
                          </div> -->
              <div class="row">
                <div class="form-group col">
                  <label class="form-label text-color-dark text-3"
                    >성별 <span class="text-color-danger">*</span></label
                  >
                  <div
                    class="form-group col form-control form-control-lg text-4"
                  >
                    <input
                      type="radio"
                      value="M"
                      v-model="gndrCtryCd"
                      required
                      class="form-check-input"
                    />
                    남
                    <input
                      type="radio"
                      value="F"
                      v-model="gndrCtryCd"
                      required
                      class="form-check-input"
                    />
                    여
                  </div>
                </div>
              </div>
              <!-- 약관 동의 모달 팝업-->
              <div class="d-flex mb-3 justify-content-center">
                <div class="row justify-content-between">
                  <div class="col-auto">
                    <button
                      type="button"
                      class="col btn btn-dark rounded-0 text-3"
                      data-bs-toggle="modal"
                      data-bs-target="#largeModal"
                      @click="fetchTerms"
                    >
                      회원정보 약관
                    </button>
                  </div>
                  <div class="col-auto d-flex align-items-center text-4">
                    <input
                      type="checkbox"
                      true-value="Y"
                      false-value="N"
                      v-model="entrprsPrvcyTrmsYn"
                      required
                      class="form-check-input"
                    />동의
                  </div>
                </div>
                <div>
                  <div v-if="errorEntrprsPrvcyTrmsYn" class="error">
                    {{ errorEntrprsPrvcyTrmsYn }}
                  </div>
                </div>

                <div
                  class="modal fade"
                  id="largeModal"
                  tabindex="-1"
                  aria-labelledby="largeModalLabel"
                  style="display: none"
                  aria-hidden="true"
                >
                  <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                      <div class="modal-header">
                        <h4 class="modal-title" id="largeModalLabel">
                          회원정보 약관
                        </h4>
                        <button
                          type="button"
                          class="btn-close"
                          data-bs-dismiss="modal"
                          aria-hidden="true"
                        ></button>
                      </div>
                      <div class="modal-body">
                        <div v-if="state.terms.length">
                          <div
                            v-for="(term, index) in state.terms"
                            :key="index"
                          >
                            <p>{{ term.trmsCntnt }}</p>
                          </div>
                        </div>
                      </div>
                      <div class="modal-footer">
                        <button
                          type="button"
                          class="btn btn-light"
                          data-bs-dismiss="modal"
                        >
                          확인
                        </button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <!-- 약관 동의 모달 팝업-->
              <!-- <div class="row">
                            <div class="form-group col">
                                <p class="text-2 mb-2">Your personal data will be used to support your experience throughout this website, to manage access to your account, and for other purposes described in our <a href="#" class="text-decoration-none">privacy policy.</a></p>
                            </div>
                        </div> -->
              <div class="row">
                <div class="form-group col">
                  <button
                    type="submit"
                    class="btn btn-dark btn-modern w-100 text-uppercase rounded-0 font-weight-bold text-3 py-3"
                    data-loading-text="Loading..."
                  >
                    회원가입 완료
                  </button>
                </div>
              </div>
              <div class="row">
                <div class="form-group col">
                  <a
                    href="#"
                    class="btn btn-dark btn-modern w-100 text-transform-none rounded-0 font-weight-bold align-items-center d-inline-flex justify-content-center text-3 py-3"
                    data-loading-text="Loading..."
                    ><i class="fab fa-facebook text-5 me-2"></i> 소셜
                    회원가입</a
                  >
                </div>
              </div>
              <button @click="submitForm"></button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, reactive, watch } from "vue";
import { enterRegisterMember } from "@/api/enter";
import axios from "axios";
import { useRouter } from "vue-router";
import {
  registerMember,
  sendEmlRegister,
  getTermsContents,
} from "@/api/member";

// 미리 저장한 axios를 사용한 함수들 import
//클라이언트가 작성한값을 실시간으로 바인딩 후 .value로 값에 접근해 사용할 수 있다.
//ref 속성을 개별적으로 선언한 느낌 , value를 통해서 접근할 수 있다.

// function ckck() {
//   const memberData2 = {
//     entrprsId: entrprsId.value,
//     entrprsPswrd: entrprsPswrd.value,
//     entrprsPicName: entrprsPicName.value,
//     entrprsName: entrprsName.value,
//     entrprsPicMp: entrprsPicMp.value,
//     entrprsPicEml: entrprsPicEml.value,
//     entrprsEmlRcvYn: entrprsEmlRcvYn.value,
//     entrprsPrvcyTrmsYn: entrprsPrvcyTrmsYn.value,
//     gndrCtgryCd: gndrCtgryCd.value,
//   };
//   registerEnter(memberData2);
// }

const cmnRgtrrtnNmbr = ref();
// let numState = ref(false);
var numState = ref(false);
const entrprsId = ref("");
const entrprsPswrd = ref("");
const pswrdConfirm = ref("");
const entrprsPicName = ref("");
const entrprsName = ref("");
const entrprsPicMp = ref("");
const entrprsPicEml = ref("");
const entrprsEmlRcvYn = ref("");
const entrprsPrvcyTrmsYn = ref("");
const gndrCtryCd = ref("");
const emailKey = ref("");
const emailCode = ref("");
const errorEntrprsId = ref("");
const errorEntrprsPswrd = ref("");
const errorEntrprsPswrdConfirm = ref("");
const errorEntrprsPicName = ref("");
const errorEntrprsPicEml = ref("");
const errorEntrprsPicMp = ref("");
const errorEntrprsEmlRcvYn = ref("");
const errorEntrprsPrvcyTrmsYn = ref("");
// const enterData = ref({});
const router = useRouter();

const state = reactive({
  terms: [],
});

// 사업자 인증부분 글자가 10 글자일때만 api요청
watch(cmnRgtrrtnNmbr, async (newQuestion) => {
  if (newQuestion.length == 10) {
    try {
      const num1 = {
        b_no: [cmnRgtrrtnNmbr.value],
      };
      const serviceKey =
        "serviceKey=9MGLj%2FNxejdwtQrtB9B%2Ft0K6YUvomLCxT%2BUL5HobSTWGNnrRf5sQz7YkPLoBVO4RVmUAi8vxqTknM6Qvle4ZCg%3D%3D";
      const URL =
        "http://api.odcloud.kr/api/nts-businessman/v1/status?" +
        serviceKey +
        "&returnType=JSON";

      const headers = {
        accept: "application/json",
      };
      console.log(num1.b_no);
      const data = num1; // json 을 string으로 변환하여 전송

      axios
        .post(URL, data, {
          headers: headers,
        })
        .then((response) => {
          if (response.data.match_cnt == 1) {
            numState.value = true;
            console.log(response.data.match_cnt);
            console.log("numState:" + numState.value);
            // router.push({ path: "/enter/register"});
          } else {
            // 여기 비동기 통신으로 올바르지 않은 입력으로 표기.
          }
        })
        .catch((response) => {
          console.log(response.responseText);
        });
    } catch (error) {
      // answer.value = "Error! Could not reach the API. " + error;
    } finally {
      // loading.value = false;
    }
  }
});

const enterRegister = function () {
  const enterData = {
    cmnRgtrrtnNmbr: cmnRgtrrtnNmbr.value,
    entrprsId: entrprsId.value,
    entrprsPswrd: entrprsPswrd.value,
    entrprsPicName: entrprsPicName.value,
    entrprsName: entrprsName.value,
    entrprsPicMp: entrprsPicMp.value,
    entrprsPicEml: entrprsPicEml.value,
    entrprsEmlRcvYn: entrprsEmlRcvYn.value,
    entrprsPrvcyTrmsYn: entrprsPrvcyTrmsYn.value,
    gndrCtryCd: gndrCtryCd.value,
  };
  enterRegisterMember(enterData);

  console.log("enterData :" + enterData);
  console.log(enterData.entrprsEmlRcvYn);
  console.log(enterData.entrprsId);
  console.log(enterData.gndrCtryCd);
};

const fetchTerms = async () => {
  try {
    const { data } = await getTermsContents();
    console.log("데이터받음", data);
    state.terms.length = 0; // 기존 배열 비우기
    state.terms.push(...data); // 새로운 데이터 추가
  } catch (error) {
    console.error("데이터를 가져오는 중 오류가 발생했습니다.", error);
  }
};

const emlSend = async () => {
  emailCode.value = "";

  try {
    const response = await sendEmlRegister(entrprsPicEml.value);
    if (
      !/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/.test(
        entrprsPicEml.value
      )
    ) {
      errorEntrprsPicEml.value = "이메일 형식이 올바르지 않습니다.";
    } else if (response.data.exist) {
      alert(response.data.exist);
    } else if (response.status === 200) {
      alert("인증코드가 발송되었습니다.");
      const key = response.data.key;
      alert(key);
      emailCode.value = key;
    } else {
      alert("잘못된 이메일입니다");
    }
  } catch (error) {
    console.error("이메일 전송 중 오류 발생:", error);
    alert("이메일 전송 중 오류가 발생했습니다.");
  }
};

const updateEmailCheck = (event) => {
  emailKey.value = event.target.value;
};

const emlChck = () => {
  if (emailCode.value === emailKey.value) {
    alert("인증완료");
  } else {
    alert("인증코드가 일치하지 않습니다.");
  }
};
// 비동기 처리
const submitForm = function () {
  errorEntrprsId.value = "";
  errorEntrprsPswrd.value = "";
  errorEntrprsPswrdConfirm.value = "";
  errorEntrprsPicName.value = "";
  errorEntrprsPicEml.value = "";
  errorEntrprsPicMp.value = "";
  errorEntrprsEmlRcvYn.value = "";
  errorEntrprsPrvcyTrmsYn.value = "";

  // 유효성 검사
  if (!/^[A-Za-z0-9]{4,12}$/.test(entrprsId.value)) {
    errorEntrprsId.value =
      "아이디는 영문, 숫자를 포함한 4자 이상 20자 이내이여야 합니다.";
    return; // 폼 제출 중단
  }
  if (!/^[A-Za-z0-9]{4,12}$/.test(entrprsPswrd.value)) {
    errorEntrprsPswrd.value =
      "비밀번호는 영문, 숫자를 포함한 4자 이상 20자 이내이여야 합니다.";
    return; // 폼 제출 중단
  }
  if (entrprsPswrd.value !== pswrdConfirm.value) {
    errorEntrprsPswrdConfirm.value = "비밀번호를 확인해주세요.";
    return; // 폼 제출 중단
  }
  if (!/^[A-Za-z가-힣]{1,6}$/.test(entrprsPicName.value)) {
    errorEntrprsPicName.value = "이름이 올바르지 않습니다.";
    return; // 폼 제출 중단
  }
  if (
    !/^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/.test(entrprsPicMp.value)
  ) {
    errorEntrprsPicMp.value = "휴대폰 형식이 올바르지 않습니다.";
    return; // 폼 제출 중단
  }
  if (
    !/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/.test(
      entrprsPicEml.value
    )
  ) {
    errorEntrprsPicEml.value = "이메일 형식이 올바르지 않습니다.";
    return; // 폼 제출 중단
  }
  if (emailCode.value !== emailKey.value) {
    errorEntrprsEmlRcvYn.value = "인증 코드가 일치하지 않습니다.";
    return; // 폼 제출 중단
  }
  if (entrprsPrvcyTrmsYn.value !== "Y") {
    errorEntrprsPrvcyTrmsYn.value = "회원정보 약관은 필수입니다.";
    return; // 폼 제출 중단
  }
  const memberData = {
    entrprsId: entrprsId.value,
    entrprsPswrd: entrprsPswrd.value,
    entrprsPicName: entrprsPicName.value,
    entrprsName: entrprsName.value,
    entrprsPicMp: entrprsPicMp.value,
    entrprsPicEml: entrprsPicEml.value,
    entrprsEmlRcvYn: entrprsEmlRcvYn.value,
    entrprsPrvcyTrmsYn: entrprsPrvcyTrmsYn.value,
    gndrCtryCd: gndrCtryCd.value,
  };

  try {
    const response = registerMember(memberData);
    if (response.status === 200) {
      alert("환영합니다.");
      router.push("/member/login");
    } else {
      alert(response.data);
    }
  } catch (error) {
    alert("Failed to register member: " + error.message);
  }
};
</script>

<style scoped>
.error {
  color: red;
}
.form-group input[type="radio"]:nth-child(2) {
  margin-left: 10px;
}
</style>