<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.12/css/dataTables.bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
<link rel="stylesheet"
	href="/runninglife/resources/css/bootstrap.min.css">
<script src="/runninglife/resources/js/bootstrap.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
</head>
<body>

	${contest.place} ${contest.startDate} ${contestName} ${begin}${end}
	${contest.goal}${contest.organizer}${contest.coorganizer}
	${contest.contestPhotoPath}


	<div class="container">
		<div class="col-lg-9 col-md-9 col-sm-9 letter-spacing-1">
			<div class="tab-content size-16">
				<div class="heading-title heading-dotted text-center margin-top-20">
					<h4>
						�v�ɳW�{<span class="margin-left-8">COMPETITION RULES</span>
					</h4>
				</div>
				<div class="table-responsive">
					<table id="example"
						class="table table-hover table-bordered lohas-table text-center">
						<tbody>
							<tr>
								<td class="col-xs-2">���ʤ��</td>
								<td class="col-xs-10 text-left">${start}</td>
							</tr>
							<tr>
								<td>���W�ɶ�</td>
								<td class="text-left">${begin}�_��~${end}���B������</td>
								<!-- <td class="text-left">2016 �~ 6 �� 17 �� 11:00 �_ �� 2016 �~ 7 �� 17 �� 23:59�� �B������</td> -->
							</tr>
							<tr>
								<td>���ʩv��</td>
								<td class="text-left">�q�д���</td>
							</tr>
							<tr>
								<td>�a��²��</td>
								<td class="text-left">�����Ϧ������f�y�H�h�Ҷ}�o�A�]���º١u�s�s���v�A�����u�s�P���s�j����v���N�A�ӡu�����v�P�u�s�s�v���f�y�o���ᬰ�ۦ��A�i���ӥѩ�ԤH�J���A�[�W��[�f�~�A�Ӫu�Ρu�����v���W�C�M�D���G�Q�G�~�A�����m���A�u�{�H�Ӧ��c�~�A��O�E���u�{�H�E���C�O�W�����饻��A�饻�⦹�a�����u�����v�B�u���f�v�B�u�T���J�v���T�Ӱϰ�C�������u���������}�o���ߡv���١A���H�J�׭�B�F�աB�Z�����a�}���A���ݸg�ѥ��a�F�]���j�ݫܦh�A�o�Ǥ�Ƹ겣�w���������֦��o�i�[���Ʒ~��O�C����E�~�T�ϲΤ@�אּ�u�����ܡv�A���ݻO���{�׭�p�����ܡC�O�W���_��l�]�u�����m�v�A����E�Q�E�~�Q�G��G�Q����אּ�����ϡC</td>
							</tr>
							<tr>
								<td>�D����</td>
								<td class="text-left">${contest.organizer}</td>
							</tr>
							<tr>
								<td>�����</td>
								<td class="text-left">${contest.coorganizer}</td>
							</tr>
							<tr>
								<td>�|���a�I</td>
								<td class="text-left">${contest.place}</td>
							</tr>
							<tr>
								<td>���W���</td>
								<td class="text-left">����17���A���ѥ[���{���ԪQ�ջP�b�{���ԪQ�դ��ɤ����A��ú��<a
									href="assets/�a���P�N��.doc" class="label label-success">�a���P�N��</a>�øg�j�|�֥i���o���W�A�_�h�������z�C�P�N��ñ�W���Email�ܡG���٦t
									�`�F��<a class="text-info"
									href="mailto:cck0936392333@yahoo.com.tw" target="_blank">cck0936392333@yahoo.com.tw</a>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div
					class="heading-title heading-border heading-color margin-top-40">
					<h4>
						<span>�v�ɤ���</span>�A���{���ԪQ�աB�b�{���ԪQ��
					</h4>
					<p>�̩ʧO�Φ~�֦@����12�աA�Ԧp�U��</p>
				</div>
				<div class="table-responsive">
					<table 
						class="table table-hover table-bordered lohas-table text-center">
						<thead>
							<tr>
								<th class="col-xs-2">�էO</th>
								<th class="col-xs-4">�~�ֽd��</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var='team' items='${teams}'>
								<tr>
									<td>${team.teamName}</td>
									<td>${team.ageRange}~${team.ageRange + 10}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
		
<script>$(document).ready(function() {
    $('#example').DataTable();
} );
</script>

	</div>
</body>
</html>